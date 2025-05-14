package com.app.frontEnd.janelas;

import com.app.frontEnd.AdicionarBotao;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JanelaPrincipal extends JFrame{
    String titulo;
    GridLayout gridLayout = new GridLayout(3, 3);

    public JanelaPrincipal(String titulo, String uName, String uPassword) {

        AdicionarBotao botaoSearch = new AdicionarBotao("Consultar Convidado", 150, 150);
        AdicionarBotao botaoRemove = new AdicionarBotao("Remover Convidado", 150,150);
        AdicionarBotao botaoAdicionar = new AdicionarBotao("Adicionar Convidado",150,150);

        setLayout(gridLayout);

        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();
        this.titulo = titulo;
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        add(botaoSearch);
        botaoSearch.setText("Consultar");
        botaoSearch.addActionListener(e -> {
            JanelaSearch janelaSearch = new JanelaSearch("Consultar Convidado", uName, uPassword);
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoSearch);

            janelaAtual.dispose();
            janelaSearch.setVisible(true);

        });

        add(botaoRemove);
        botaoRemove.setText("Remover");
        botaoRemove.addActionListener(e -> {
            JanelaRemove janelaRemove = new JanelaRemove("Remover convidado", uName, uPassword);
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoRemove);

            janelaAtual.dispose();
            janelaRemove.setVisible(true);

        });

        add(botaoAdicionar);
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(e -> {
            JanelaAdd janelaAdd = new JanelaAdd("Adicionar convidado", uName, uPassword);
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoAdicionar);

            janelaAtual.dispose();
            janelaAdd.setVisible(true);

        });


    }

}
