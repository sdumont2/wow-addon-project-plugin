package com.dumontsean.wow.addon.plugin.config;

import com.intellij.openapi.ui.panel.ComponentPanelBuilder;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WcaFirstConfigPanel extends JPanel {

    private JPanel myRoot;
    private static WcaProjectHeaderLabel textPane = new WcaProjectHeaderLabel();

    public WcaFirstConfigPanel() {
        super(new BorderLayout());

        Border emptyBorder = JBUI.Borders.customLine(JBUI.CurrentTheme.ToolWindow.headerBorderBackground(), 0);
        myRoot.setBorder(emptyBorder);

        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                null, 0, 0);

        addComponentToPanel(myRoot, textPane, gbc);

        myRoot.setSize(getSize());

        add(myRoot, BorderLayout.CENTER);
    }

    private void addComponentToPanel(JPanel panel, JComponent component, GridBagConstraints gbc) {
        ComponentPanelBuilder panelBuilder = new ComponentPanelBuilder(component);

        panelBuilder.addToPanel(panel, gbc);
    }

    private void createUIComponents() {

    }
}