package com.dumontsean.wow.addon.plugin.config;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.ComponentWithBrowseButton;
import com.intellij.openapi.ui.TextComponentAccessor;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.SystemProperties;
import org.jetbrains.annotations.NotNull;

public class WcaPathChooser extends ComponentWithBrowseButton<JBTextField> {

    private String fieldName;

    private static final FileChooserDescriptor fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor();
    private static JBTextField textField = new JBTextField(FileUtil.toSystemDependentName(SystemProperties.getUserHome()));
    private static TextComponentAccessor<JBTextField> accessor = new WcaJBTextFieldAccessor();


    public WcaPathChooser(String fieldName, String description) { //TODO Figure Out what to do here. Can use the text field with browse button as the file chooser and somehow attach to it?
        super(textField, null);
        textField.setEditable(false);
        BrowseFolderActionListener<JBTextField> actionListener = new BrowseFolderActionListener<JBTextField>(fieldName, description, this, null, fileChooserDescriptor, accessor);
        addActionListener(actionListener);
        this.fieldName = fieldName;
    }

    public Pair<String, String> result() {
        return new Pair<>(fieldName, accessor.getText(textField));
    }

    private static class WcaJBTextFieldAccessor implements TextComponentAccessor<JBTextField> {
        @Override
        public String getText(JBTextField component) {
            return component != null ?  FileUtil.toSystemDependentName(component.getText()) : "";
        }

        @Override
        public void setText(JBTextField component, @NotNull String text) {
            component.setText(FileUtil.toSystemDependentName(text));
        }
    }
}
