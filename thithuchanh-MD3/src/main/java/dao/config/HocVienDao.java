package dao.config;


import model.HocVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocVienDao {
    static Connection connection = ConnectMySql.getConnection();

    public static List<HocVien> getAll() {
        String selectAll = "SELECT hocvien.*, classroom.name as classname FROM mini_test_module3.hocvien join classroom on hocvien.idClassroom = classroom.id";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            List<HocVien> hocViens = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Date date = resultSet.getDate("date");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String className = resultSet.getString("classname");
                int idClassRoom = resultSet.getInt("idClassRoom");
                hocViens.add(new HocVien(id, name, address, date, phone, email, className, idClassRoom));
            }
            return hocViens;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveHocVien(HocVien hocVien) {
        String insert = "INSERT INTO hocvien (`name`, `address`, `date`, `phone`, `email`,`idClassRoom`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, hocVien.getName());
            preparedStatement.setString(2, hocVien.getAddress());
            preparedStatement.setDate(3, hocVien.getDate());
            preparedStatement.setString(4, hocVien.getPhone());
            preparedStatement.setString(5, hocVien.getEmail());
            preparedStatement.setInt(6, hocVien.getClassRoom());

            preparedStatement.execute();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(HocVien hocVien) {
        try {
            String sql = "update student set Name = ? ,DateofBirth = ? ,Address = ?,PhoneNumber = ?, Email = ?, idClassroom = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hocVien.getName());
            preparedStatement.setDate(2, hocVien.getDate());
            preparedStatement.setString(3, hocVien.getAddress());
            preparedStatement.setString(4, hocVien.getPhone());
            preparedStatement.setString(5, hocVien.getEmail());
            preparedStatement.setInt(6, hocVien.getClassRoom());
            preparedStatement.setInt(7, hocVien.getId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteUser(int idStudent) {
        try {
            String sql = "DELETE FROM student WHERE id = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<HocVien> findByName(String nameFind) {
        String find = "SELECT hocvien.*, classroom.name as classname FROM mini_test_module3.hocvien join classroom on hocvien.idClassroom = classroom.id\n" +
                "where hocvien.name like '%" + nameFind + "%\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(find);
            List<HocVien> hocViens = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Date date = resultSet.getDate("date");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String className = resultSet.getString("classname");
                int idClassRoom = resultSet.getInt("idClassRoom");
                hocViens.add(new HocVien(id, name, address, date, phone, email, className, idClassRoom));
            }
            return hocViens;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void deleteByID(int id) {
        String sql = "delete from hocvien where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
