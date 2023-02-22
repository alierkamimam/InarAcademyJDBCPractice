package org.example;

import java.sql.*;

public class Question6 {
    public static void answer6() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password = "asd";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query="SELECT first_name,last_name, c.city,co.country,sum(p.amount)\n" +
                "FROM address a\n" +
                "JOIN city c  ON a.city_id=c.city_id\n" +
                "JOIN country co ON c.country_id=co.country_id\n" +
                "JOIN customer cu ON a.address_id=cu.address_id\n" +
                "JOIN payment p ON cu.customer_id=p.customer_id\n" +
                "GROUP BY first_name,last_name,city,country\n" +
                "ORDER BY sum(p.amount) DESC\n" +
                "LIMIT 1";

        ResultSet resultSet= statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Sum : "+resultSet.getString("first_name"));
        }


    }
}
