package com.dumontsean.wow.addon.plugin.config;

import com.dumontsean.wow.addon.plugin.utils.MessagesUtil;
import com.intellij.util.ui.JBUI;

import javax.swing.*;

public class WcaProjectHeaderLabel extends JLabel {

    public WcaProjectHeaderLabel() {
        super();
        super.setText("<html><h1>" + MessagesUtil.PROJECT_HEADER + "</h1><br/><br/><p>" + MessagesUtil.PROJECT_DESCRIPTION + "</p></html>");
        super.setFont(JBUI.CurrentTheme.ToolWindow.headerFont().deriveFont(18.0F));
    }

}
