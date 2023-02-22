package org.example;

import java.sql.*;

public class Question5 {
    public static void answer5() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password = "password";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query="SELECT co.country , SUM(amount) from country co\n" +
                "JOIN city ci ON co.country_id=ci.country_id\n" +
                "JOIN address a ON ci.city_id=a.city_id\n" +
                "JOIN customer cu ON a.address_id=cu.address_id\n" +
                "JOIN payment p ON cu.customer_id=p.customer_id\n" +
                "GROUP BY  co.country  \n" +
                "HAVING SUM(amount)>800\n" +
                "ORDER BY SUM(amount) DESC";

        ResultSet resultSet= statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Country: "+resultSet.getString("country")+
                    "  Sum :"+resultSet.getString("sum"));

        }


    }
}
