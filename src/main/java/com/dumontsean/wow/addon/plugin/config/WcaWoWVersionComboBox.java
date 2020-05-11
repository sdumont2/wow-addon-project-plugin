package com.dumontsean.wow.addon.plugin.config;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.util.Pair;

public class WcaWoWVersionComboBox extends ComboBox<String> {

    private String fieldName;

    //TODO i18 these options
    public WcaWoWVersionComboBox(String fieldName) {
        super(new String[]{ "classic", "live" });
        this.setSelectedItem("classic"); //Start somewhere
        this.fieldName = fieldName;
    }

    public Pair<String, String> result(){
        return new Pair<>(fieldName, String.valueOf(this.getSelectedItem()));
    }
}
