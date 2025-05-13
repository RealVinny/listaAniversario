package com.app.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveObject {
    String url;


    public RemoveObject(String url) {

        try {
            Scanner sc = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM convidados WHERE nome = ?");
            System.out.println("informe o nome do convidado a remover:");
            stmt.setString(1, sc.nextLine());

            int quantDeletados = stmt.executeUpdate();

            if(quantDeletados >0){
                System.out.println("convidado deletado");
            }else{
                System.out.println("convidado não foi deletado corretamente !");
            }


        }catch (Exception e){
            System.err.println(e);
        }
}

}
