package com.app.frontEnd;

import javax.swing.*;
import javax.swing.text.Document;

public class NovoTextField extends JTextField {
    public NovoTextField() {
    }

    public NovoTextField(String text) {
        super(text);
    }

    public NovoTextField(int columns) {
        super(columns);
    }

    public NovoTextField(String text, int columns) {
        super(text, columns);
    }

    public NovoTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }
}
