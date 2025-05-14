package com.app.frontEnd.janelas;

import javax.swing.*;
import java.awt.*;

public class JanelaAdd extends JanelaPrincipal{

    public JanelaAdd(String titulo, String uNome, String uPassword) {
        super(titulo, uNome, uPassword);
        Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) tamanhoJanela.getWidth();
        int altura = (int) tamanhoJanela.getHeight();
        this.titulo = titulo;
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

    }
}
