package com.app.backEnd.dabataseFunc;

import com.app.backEnd.connectionFunc.ConnectarDatabase;

import javax.swing.*;
import java.sql.*;

public class SearchObject extends ConnectarDatabase {
    private String url;
    private final String user;
    private final String password;


    public SearchObject(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public ResultSet searchObject(String uName) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/listaDeAniversario";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM convidados WHERE nome=?");
            pStmt.setString(1, uName);
            ResultSet resultSet = pStmt.executeQuery();

            if(resultSet.next()) {

                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                String local = resultSet.getString("local");
                String resultado = "nome :" + nome + "\nidade :" + idade + "\nlocal :" + local;

                JOptionPane.showMessageDialog(null, resultado);

            }

        }


        return null;
    }

}
