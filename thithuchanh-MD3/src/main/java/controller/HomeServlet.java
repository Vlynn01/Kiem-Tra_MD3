package controller;


import dao.config.HocVienDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HocVien;
import service.ClassRoomService;
import service.HocVienService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    HocVienService hocVienService = new HocVienService();
    ClassRoomService classRoomService = new ClassRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        RequestDispatcher requestDispatcher;
        switch (action) {
            case "create":
                req.setAttribute("listClass", classRoomService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/createHocVien.jsp");
                requestDispatcher.forward(req, resp);
                break;

            case "edit":

                break;

            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                hocVienService.deleteByID(id);
                req.setAttribute("listHV", hocVienService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
                requestDispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("listHV", hocVienService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        RequestDispatcher requestDispatcher;

        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Date date = Date.valueOf(LocalDate.parse(req.getParameter("date")));
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int idClassRoom = Integer.parseInt(req.getParameter("idClassRoom"));
                System.out.println(req.getParameter("date"));
                hocVienService.save(new HocVien(name, address, date, phone, email, idClassRoom));
                resp.sendRedirect("/home");
                break;

            case "edit":
                showEditForm(req, resp);
                break;


            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                HocVien hocVien = findById(id);
                req.setAttribute("student", hocVien);
                RequestDispatcher dispatcherd = req.getRequestDispatcher("/view/delete.jsp");
                dispatcherd.forward(req, resp);
                break;

            case "search":
                String nameSearch = req.getParameter("search");
                req.setAttribute("listHV", hocVienService.findByName(nameSearch));
                requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
                requestDispatcher.forward(req, resp);
                break;
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        HocVien hocVien = findById(id);
        RequestDispatcher dispatcher;
        if (hocVien == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", hocVien);
            dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HocVien findById(int id) {
        for (HocVien st : HocVienDao.getAll()
        ) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }
}
