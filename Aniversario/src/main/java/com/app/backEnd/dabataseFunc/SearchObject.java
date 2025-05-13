package com.app.backEnd.dabataseFunc;

import com.app.backEnd.connectionFunc.ConnectarDatabase;

import java.sql.*;
import java.util.Scanner;

public class SearchObject extends ConnectarDatabase {
    private String url;
    private String user;
    private String password;


    public void searchObject() throws SQLException {
        Scanner sc = new Scanner(System.in);
       try(Connection connection = DriverManager.getConnection(url, user, password)) {

           while(true) {
               System.out.println("voce quer consultar por nome ou local?");
               System.out.println("NOTA : É RECOMENDADO QUE VOCÊ FAÇA UMA BUSCA POR NOME");

               if (sc.nextLine().equalsIgnoreCase("nome")) {
                   System.out.println("procurando convidados de acordo com nome");
                   PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM convidados WHERE nome=?");
                   pStmt.setString(1, sc.nextLine());

                   ResultSet resultSet = pStmt.executeQuery();

                   while (resultSet.next()){
                       String nome = resultSet.getString("nome");
                       String local = resultSet.getString("local");
                       int idade = resultSet.getInt("idade");

                       System.out.println("nome :" + nome +"\nlocal :" + local + "\nidade :" + idade);

                   }
               } else if (sc.nextLine().equalsIgnoreCase("local")) {
                   System.out.println("procurando convidados de acordo com local");
                   PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM convidados WHERE local=?");
                   pStmt.setString(1, sc.nextLine());

                   ResultSet resultSet = pStmt.executeQuery();

                   while (resultSet.next()){
                       String nome = resultSet.getString("nome");
                       String local = resultSet.getString("local");
                       int idade = resultSet.getInt("idade");

                       System.out.println("nome :" + nome +"\nlocal :" + local + "\nidade :" + idade);

                   }


               } else {
                   System.out.println("voce informou um dado não disponivel");
                   break;
               }

            break;

           }

       }

    }

}
