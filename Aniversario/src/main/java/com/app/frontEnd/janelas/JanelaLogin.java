package com.app.frontEnd.janelas;

import com.app.backEnd.connectionFunc.ConnectarDatabase;
import com.app.frontEnd.AdicionarBotao;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class JanelaLogin extends JanelaPrincipal {

    JButton botaoLogin = new JButton("botao de login");

    public JanelaLogin(String titulo) throws SQLException {
        super(titulo);
        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();
        this.titulo = titulo;


        JTextField textField = new JFormattedTextField();
        JPasswordField passwordField = new JPasswordField();
        add(textField);
        textField.setBounds(150, 150, 100,100);
        add(passwordField);
        passwordField.setBounds(300,300, 100, 100);

        add(botaoLogin);
        botaoLogin.addActionListener(e -> {

            String usuario = textField.getText();
            String senha = new String(passwordField.getPassword());

            System.out.println( usuario + senha);

            try {
                Connection conexao = ConnectarDatabase.connectar(usuario, senha);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "erro :" + ex.getMessage());

            }

        });




        setTitle(titulo);
        setSize(largura, altura);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        setVisible(true);




    }


}
