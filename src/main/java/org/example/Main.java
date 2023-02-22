package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args)  {

        try {
            Question6.answer6();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}