package com.app.functions;

import java.sql.*;
import java.util.Scanner;

public class AddObject {
    private String url;
    private String user;
    private String password;

    public AddObject(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addObject() throws SQLException {

        Scanner sc = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(url, user, password)){

            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO convidados(nome, idade, local) VALUES(?,?,?)");

            System.out.println("informe o local que foi conhecido");
            pStmt.setString(3, sc.nextLine());

            System.out.println("informe o nome do convidado");
            String name = sc.nextLine();
            pStmt.setString(1, name);

            System.out.println("informe a idade do convidado");
            pStmt.setInt(2, sc.nextInt());


            int afetadas = pStmt.executeUpdate();
            if(afetadas > 0){
                PreparedStatement statement = connection.prepareStatement("SELECT  * FROM convidados where nome = ? ");
                statement.setString(1, name);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String local = resultSet.getString("local");

                    System.out.println("id :" + id + "\nnome :" + name + "\nlocal :" +local);




                }



           }else{
                System.out.println("não foi possivel adicionar o user");
            }


            connection.close();
        } catch (Exception e) {

            System.err.println(e.getMessage());

        }


    }


}
