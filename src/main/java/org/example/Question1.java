package org.example;

import java.sql.*;

public class Question1 {
    public static  void answer1() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/exercises";
        String userName = "postgres";
        String password = "password";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String firstQuery = "SELECT TO_CHAR(joindate,'Month') AS month,COUNT(memid) \n" +
                "FROM cd.members\n" +
                "GROUP BY TO_CHAR(joindate,'Month')\n" +
                "ORDER BY COUNT(memid) DESC\n" +
                "LIMIT 1";
        ResultSet resultSet =statement.executeQuery(firstQuery);

        int count=1;
        while (resultSet.next()){
            System.out.print(resultSet.getString("month"));
            System.out.println(resultSet.getString("count"));



        }


    }
}
