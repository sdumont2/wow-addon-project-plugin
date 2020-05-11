package com.dumontsean.wow.addon.plugin.config;

import com.intellij.openapi.ui.panel.ComponentPanelBuilder;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static com.dumontsean.wow.addon.plugin.utils.MessagesUtil.*;

public class WcaLastConfigPanel extends JPanel {

    private static WcaWoWVersionComboBox wowVersion;
    private static WcaPathChooser libsPath;
    private static JBCheckBox includeAce;

    static {
        wowVersion = new WcaWoWVersionComboBox(LIB_WOW_VERSION_LABEL);
        libsPath = new WcaPathChooser(LIB_LOCATION_LABEL, LIB_LOCATION_DESC);
        includeAce = new JBCheckBox();
    }

    private JPanel myRoot;

    public WcaLastConfigPanel() {
        super(new BorderLayout());

        Border emptyBorder = JBUI.Borders.customLine(JBUI.CurrentTheme.ToolWindow.headerBorderBackground(), 0);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(emptyBorder, LIB_DESC,
                TitledBorder.CENTER, TitledBorder.BELOW_TOP, JBUI.CurrentTheme.ToolWindow.headerFont().deriveFont(24.0F));
        myRoot.setBorder(titledBorder);

        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL,
                null, 0, 0);

        addComponentToPanel(myRoot, wowVersion, LIB_WOW_VERSION_LABEL, LIB_WOW_VERSION_DESC, gbc);
        addComponentToPanel(myRoot, libsPath, LIB_LOCATION_LABEL, LIB_LOCATION_DESC, gbc);
        addComponentToPanel(myRoot, includeAce, LIB_ACE_LABEL, LIB_ACE_DESC, gbc);

        myRoot.setSize(getSize());

        add(myRoot, BorderLayout.CENTER);
    }

    private void addComponentToPanel(JPanel panel, JComponent component, String label, String description, GridBagConstraints gbc) {
        ComponentPanelBuilder panelBuilder = new ComponentPanelBuilder(component).withLabel(label).withComment(description);

        panelBuilder.addToPanel(panel, gbc);
    }

    public String getWowVersion() {
        return wowVersion.result().getSecond();
    }

    public String getLibsPath() {
        return libsPath.result().getSecond();
    }

    public boolean includeAce() {
        return includeAce.isSelected();
    }
}
