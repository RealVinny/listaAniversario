package com.app.frontEnd.janelas;

import com.app.backEnd.connectionFunc.ConnectarDatabase;
import com.app.frontEnd.AdicionarBotao;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class JanelaLogin extends JFrame{

    GridLayout gridLayout = new GridLayout(2, 3);
    AdicionarBotao botaoLogin = new AdicionarBotao("botao login", 100, 100);

    public JanelaLogin(String titulo) throws SQLException {

        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();

        JTextField textField = new JFormattedTextField();
        JPasswordField passwordField = new JPasswordField();

        add(textField);
        textField.setBounds(largura/2, altura/2+100, 300,100);

        add(passwordField);
        passwordField.setBounds(largura/2, altura/2+200, 300, 100);

        add(botaoLogin);
        botaoLogin.setBounds(largura/2,altura/2+300,300,100);
        botaoLogin.setText("botaoLogin");
        botaoLogin.addActionListener(e -> {

            String usuario = textField.getText();
            String senha = new String(passwordField.getPassword());

            try {

                Connection conexao = ConnectarDatabase.connectar(usuario, senha);
                Window janelaAtual = SwingUtilities.getWindowAncestor(botaoLogin);
                JOptionPane.showMessageDialog(this ,"conexão estabelecida com sucesso");
                janelaAtual.dispose();

                JanelaPrincipal janelaPrincipal = new JanelaPrincipal("- Bem-vindo -", usuario, senha);
                janelaPrincipal.setVisible(true);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "erro :" + ex.getMessage());

            }


        });

        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);




    }


}
