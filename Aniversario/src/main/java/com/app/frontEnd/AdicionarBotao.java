package com.app.frontEnd;

import javax.swing.*;
import java.awt.*;

public class AdicionarBotao extends JButton{
        String titulo;

    public AdicionarBotao(String titulo, int largura, int altura) {
        this.titulo = titulo;
        setSize(largura, altura);

    }
}
