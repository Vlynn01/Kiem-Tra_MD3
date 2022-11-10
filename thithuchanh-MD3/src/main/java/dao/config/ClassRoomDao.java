package dao.config;


import model.ClassRoom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDao {
    static Connection connection = ConnectMySql.getConnection();

    public static List<ClassRoom> getAll() {
        String selectAll = "select * from classroom";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            List<ClassRoom> list = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new ClassRoom(id, name));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
