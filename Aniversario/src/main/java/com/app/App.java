package com.app;


import com.app.backEnd.connectionFunc.ConnectarDatabase;
import com.app.backEnd.dabataseFunc.AddObject;
import com.app.backEnd.dabataseFunc.RemoveObject;
import com.app.backEnd.dabataseFunc.SearchObject;
import com.app.frontEnd.AdicionarBotao;
import com.app.frontEnd.janelas.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        AddObject addObject = new AddObject();
        SearchObject searchObject = new SearchObject();
        RemoveObject removeObject = new RemoveObject();


        JanelaLogin janelaLogin = new JanelaLogin("Janela de login");
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal("Janela principal");
        JanelaSearch janelaSearch = new JanelaSearch("Janela de procura");
        JanelaRemove janelaRemove = new JanelaRemove("Janela de remoção");
        JanelaAdd janelaAdd = new JanelaAdd("Janela de inclusão");

        GridLayout gridLayout = new GridLayout(3, 3);

        AdicionarBotao botaoProcura = new AdicionarBotao("botão de procura", 25, 25);
        botaoProcura.setBounds(50, 50, botaoProcura.getWidth(), botaoProcura.getHeight());
        botaoProcura.addActionListener(e -> {

            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoProcura);
            janelaAtual.dispose();
            janelaSearch.setVisible(true);

        });

        AdicionarBotao botaoAdd = new AdicionarBotao("botão de adição", 25, 25);
        botaoAdd.setBounds(75, 75, botaoAdd.getWidth(), botaoAdd.getHeight());
        botaoAdd.addActionListener(e -> {

            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoAdd);
            janelaAtual.dispose();
            janelaAdd.setVisible(true);
        });

        AdicionarBotao botaoInicial1 = new AdicionarBotao("botao de inicio", 25, 25);
        botaoInicial1.setBounds(100, 100, botaoInicial1.getWidth(), botaoInicial1.getWidth());
        botaoInicial1.addActionListener(e -> {
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoInicial1);
            janelaAtual.dispose();
            janelaPrincipal.setVisible(true);


        });

        AdicionarBotao botaoInicial2 = new AdicionarBotao("botao de inicio", 25, 25);
        botaoInicial2.setBounds(100, 100, botaoInicial2.getWidth(), botaoInicial2.getWidth());
        botaoInicial2.addActionListener(e -> {
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoInicial1);
            janelaAtual.dispose();
            janelaPrincipal.setVisible(true);


        });

        AdicionarBotao botaoInicial3 = new AdicionarBotao("botao de inicio", 25, 25);
        botaoInicial3.setBounds(100, 100, botaoInicial3.getWidth(), botaoInicial3.getWidth());
        botaoInicial3.addActionListener(e -> {
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoInicial1);
            janelaAtual.dispose();
            janelaPrincipal.setVisible(true);


        });

        AdicionarBotao  botaoRemover = new AdicionarBotao("botao de remoção", 25, 25);
        botaoRemover.setBounds(125, 125, botaoRemover.getWidth(), botaoRemover.getHeight());
        botaoRemover.addActionListener(e -> {
            Window janelaAtual = SwingUtilities.getWindowAncestor(botaoRemover);
            janelaAtual.dispose();

            janelaRemove.setVisible(true);

        });




        //configurando janela de login
        janelaLogin.setLayout(gridLayout);
        janelaLogin.setBackground(Color.white);
        janelaLogin.setVisible(true);

        //configurando janela principal
        janelaPrincipal.setLayout(gridLayout);
        janelaPrincipal.setBackground(Color.darkGray);
        janelaPrincipal.add(botaoProcura);
        janelaPrincipal.add(botaoRemover);
        janelaPrincipal.add(botaoAdd);


        //configurando janela de procura
        janelaSearch.setLayout(null);
        janelaSearch.setBackground(Color.WHITE);
        janelaSearch.add(botaoInicial1);


        //configurando janela de adiçao
        janelaAdd.setLayout(null);
        janelaAdd.setBackground(Color.darkGray);
        janelaAdd.add(botaoInicial2);

        //configurando janela de remoção
        janelaRemove.setLayout(null);
        janelaRemove.setBackground(Color.red);
        janelaRemove.add(botaoInicial3);



    }
}
