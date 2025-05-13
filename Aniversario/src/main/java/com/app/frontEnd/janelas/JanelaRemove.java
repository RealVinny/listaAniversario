package com.app.frontEnd.janelas;

import javax.swing.*;
import java.awt.*;

public class JanelaRemove extends JanelaPrincipal{
    public JanelaRemove (String titulo) {
        super(titulo);
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
