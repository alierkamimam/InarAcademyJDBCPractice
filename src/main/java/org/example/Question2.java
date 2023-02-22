package org.example;

import java.sql.*;

public class Question2 {
    public static void answer2() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password="password";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        /*
         1)The last 3 person’s name and rent date, who had rent any film of actor “Ed Chase”
    SELECT CONCAT(c.first_name,' ',c.last_name) AS name,rental_date
    FROM customer c
    JOIN rental r ON c.customer_id=r.customer_id
    JOIN inventory i ON r.inventory_id=i.inventory_id
    JOIN film_actor fa ON i.film_id=fa.film_id
    JOIN actor a ON fa.actor_id=a.actor_id
    WHERE a.first_name='Ed' AND a.last_name ='Chase'
    ORDER BY rental_date DESC
    LIMIT 3
         */
        String query = "SELECT CONCAT(c.first_name,' ',c.last_name) AS name,rental_date\n" +
                "    FROM customer c\n" +
                "    JOIN rental r ON c.customer_id=r.customer_id\n" +
                "    JOIN inventory i ON r.inventory_id=i.inventory_id\n" +
                "    JOIN film_actor fa ON i.film_id=fa.film_id\n" +
                "    JOIN actor a ON fa.actor_id=a.actor_id\n" +
                "    WHERE a.first_name='Ed' AND a.last_name ='Chase'\n" +
                "    ORDER BY rental_date DESC\n" +
                "    LIMIT 3";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Name: "+resultSet.getString("name")+
                    "  Rental date  "+resultSet.getString("rental_date"));
        }


    }
}
