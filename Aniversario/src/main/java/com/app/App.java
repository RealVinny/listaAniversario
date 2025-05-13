package com.app;


import com.app.functions.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/listaDeAniversario";
        System.out.println("informe seu user");
        String user = sc.nextLine();

        System.out.println("informe a senha");
        String password = sc.nextLine();


        try(Connection con = DriverManager.getConnection(url, user, password)){
            AddObject addObject = new AddObject(url, user, password);

            addObject.addObject();
            System.out.println("deu certo");

            SearchObject searchObject = new SearchObject(url, user, password);
            searchObject.searchObject();
            System.out.println("deu certo dnv");

            RemoveObject removeObject = new RemoveObject(url, user, password);
            removeObject.removeObject();
            System.out.println("deu certo dnv+1");


        }catch (Exception e){
            System.err.println(e.getMessage());
        }





    }
}
