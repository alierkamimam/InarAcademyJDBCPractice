package org.example;

import java.sql.*;

public class Question3 {
    public static void answer3() throws SQLException {
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String userName="postgres";
        String password="password";

        Connection connection= DriverManager.getConnection(dbUrl,userName,password);

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                /*
                2)Find the staff’s name, username and password who is working in the store that sells “Glass Dying” film
                SELECT sf.first_name,sf.username,sf.password
                FROM staff sf
                JOIN inventory i ON sf.store_id=i.store_id
                JOIN film f ON i.film_id=f.film_id
                WHERE f.title='Glass Dying'
                GROUP BY sf.first_name,sf.username,sf.password        String password = "password";


                 */
        String query="SELECT sf.first_name,sf.username,sf.password\n" +
                "                FROM staff sf\n" +
                "                JOIN inventory i ON sf.store_id=i.store_id\n" +
                "                JOIN film f ON i.film_id=f.film_id\n" +
                "                WHERE f.title='Glass Dying'\n" +
                "                GROUP BY sf.first_name,sf.username,sf.password";

        ResultSet resultSet= statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("First Name :"+resultSet.getString("first_name")+
                    "| Username :"+resultSet.getString("username")+
                    "| Password :"+resultSet.getString("password"));

        }
    }
}
