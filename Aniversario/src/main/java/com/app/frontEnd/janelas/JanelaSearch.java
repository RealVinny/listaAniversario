package com.app.frontEnd.janelas;

import com.app.backEnd.dabataseFunc.SearchObject;
import com.app.frontEnd.AdicionarBotao;
import com.google.protobuf.DescriptorProtos;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class JanelaSearch extends JFrame{

    GridLayout gridLayout = new GridLayout(2, 1);
    public JanelaSearch(String titulo, String uNome, String uPassword) {
        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(gridLayout);

        JTextField nUsuario = new JTextField();
        add(nUsuario);
        AdicionarBotao botaoSearch = new AdicionarBotao("Realizar consulta", 100, 100);

        add(botaoSearch);
        botaoSearch.setText("Consultar");
        botaoSearch.addActionListener(e -> {

        SearchObject searchObject = new SearchObject(uNome, uPassword);
            try {
                if (searchObject.searchObject(nUsuario.getText()) == null){

                    Window janelaAtual = SwingUtilities.getWindowAncestor(botaoSearch);
                    janelaAtual.dispose();

                    JanelaPrincipal janelaPrincipal = new JanelaPrincipal("- Bem vindo -", uNome, uPassword);
                    janelaPrincipal.setVisible(true);

                }else {

                    JOptionPane.showMessageDialog(null, searchObject.searchObject(nUsuario.getText()));
                    Window janelaAtual = SwingUtilities.getWindowAncestor(botaoSearch);


                    JanelaPrincipal janelaPrincipal = new JanelaPrincipal("- Bem vindo -", uNome, uPassword);
                    janelaPrincipal.setVisible(true);

                    janelaAtual.dispose();

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });






    }
}
