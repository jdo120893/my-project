package org.example.junggo_project.junggo.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/junggo";
        String user = "jun";
        String password = "jun";

        return DriverManager.getConnection(url, user, password);
    }
}