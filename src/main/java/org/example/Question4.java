package org.example;

import java.sql.*;

public class Question4 {
    public static void answer4() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password = "password";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //3) What are the names of top 5 categories, that have more than 150 films in inventory of store-1?

        String query = "SELECT COUNT(name) as count ,name\n" +
                "FROM category c\n" +
                "JOIN film_category fc ON c.category_id=fc.category_id\n" +
                "JOIN inventory i ON fc.film_id=i.film_id\n" +
                "WHERE store_id=1 \n" +
                "GROUP BY name \n" +
                "HAVING COUNT(name)>=150 \n" +
                "ORDER BY COUNT(name)  DESC\n" +
                "LIMIT 5";

        ResultSet resultSet=statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Count: "+resultSet.getString("count")
           +"  Name: "+resultSet.getString("name"));
        }



    }
}
