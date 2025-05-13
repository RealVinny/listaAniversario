package com.app.backEnd.connectionFunc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectarDatabase {


    public static Connection connectar (String user, String password) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3305/listaDeAniversario";

        return DriverManager.getConnection(url, user, password);
    }

}
