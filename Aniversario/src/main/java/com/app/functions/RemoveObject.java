package com.app.functions;

import java.sql.*;
import java.util.Scanner;

public class RemoveObject {
    private final String url;
    private final String user;
    private final String password;

    public RemoveObject(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void removeObject() throws SQLException{

            Scanner sc = new Scanner(System.in);
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement pStmt = connection.prepareStatement("DELETE FROM convidados WHERE nome=?");
            PreparedStatement cStmt = connection.prepareStatement("SELECT * FROM convidados WHERE nome =?");

            System.out.println("informe o convidado a ser deletado");
            String convidado = sc.nextLine();

            pStmt.setString(1, convidado);
            cStmt.setString(1, convidado);

            System.out.println("consultando informações");

            ResultSet resultSet = cStmt.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String local = resultSet.getString("local");
                int idade = resultSet.getInt("idade");

                System.out.println("nome :" + nome + "\nidade :" + idade + "\nlocal :" + local + "\n");

                System.out.println("confirma esses dados ? (S/N)");
                if(sc.nextLine().equalsIgnoreCase("S")){
                    pStmt.executeUpdate();

                    System.out.println("usuario deletado com sucesso !");
                    break;
                }else {
                    System.out.println("operação cancelada");
                    break;
                }

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}


