package com.app.backEnd.dabataseFunc;

import com.app.backEnd.connectionFunc.ConnectarDatabase;
import jdk.jshell.execution.JdiDefaultExecutionControl;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class RemoveObject extends ConnectarDatabase {
    private String url;
    private  String user;
    private  String password;

    public RemoveObject(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void removeObject(String userName) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/listaDeAniversario";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {

            SearchObject searchObject = new SearchObject(user, password);

           if (userName == null){
             JOptionPane.showMessageDialog(null, "Informe um nome para consultar !");
           } else if (searchObject.searchObject(userName) != null) {
               JOptionPane.showMessageDialog(null, searchObject.searchObject(userName));
           }

            String confirmacao = JOptionPane.showInputDialog("confirma a consulta? (S/N)");

            if(confirmacao.equalsIgnoreCase("S")){

                    PreparedStatement pStmt = connection.prepareStatement("DELETE FROM convidados WHERE nome=?");
                    pStmt.setString(1, userName);
                    pStmt.executeUpdate();

                if(pStmt.executeUpdate() == 1){
                    JOptionPane.showMessageDialog(null, "Usuario " + userName +" removido com sucesso!");
                }

                }else{
                JOptionPane.showMessageDialog(null, "Operaçao cancelada");
            }

            }

    }

}


