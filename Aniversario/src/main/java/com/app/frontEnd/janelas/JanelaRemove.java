package com.app.frontEnd.janelas;

import com.app.backEnd.connectionFunc.ConnectarDatabase;
import com.app.backEnd.dabataseFunc.RemoveObject;
import com.app.backEnd.dabataseFunc.SearchObject;
import com.app.frontEnd.AdicionarBotao;
import com.app.frontEnd.NovoTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class JanelaRemove extends JFrame{

        GridLayout gridLayout1 = new GridLayout(2, 1);

        public JanelaRemove (String titulo, String uName, String uPassword) {

        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(gridLayout1);

        JTextField userName = new JTextField();
        add(userName);

        AdicionarBotao botaoBusca = new AdicionarBotao("botao de busca", 100, 100);
        add(botaoBusca);
        botaoBusca.setText("Buscar");
        botaoBusca.addActionListener(e -> {
                try {
                        Connection connection = ConnectarDatabase.connectar(uName, uPassword);

                        RemoveObject removeObject = new RemoveObject(uName, uPassword);
                        removeObject.removeObject(userName.getText());
                        JanelaPrincipal janelaPrincipal = new JanelaPrincipal("- Bem vindo -", uName, uPassword);
                        janelaPrincipal.setVisible(true);
                        dispose();
                } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        });






    }
}
