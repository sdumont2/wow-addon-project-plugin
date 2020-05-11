package com.dumontsean.wow.addon.plugin.config;

import com.intellij.openapi.util.Pair;

import javax.swing.*;

public class WcaTextField extends JTextField {

    private String fieldName;

    public WcaTextField(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

    public Pair<String, String> result() {
        return new Pair<>(fieldName, this.getText());
    }
}
