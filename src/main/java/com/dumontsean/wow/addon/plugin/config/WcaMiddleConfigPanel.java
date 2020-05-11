package com.dumontsean.wow.addon.plugin.config;


import com.intellij.openapi.ui.panel.ComponentPanelBuilder;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static com.dumontsean.wow.addon.plugin.utils.MessagesUtil.*;

public class WcaMiddleConfigPanel extends JPanel {

    private static WcaTextField interfaceVersion;
    private static WcaTextField title;
    private static WcaTextField notes;
    private static WcaTextField author;
    private static WcaTextField addonVersion;
    private static WcaTextField mainFileName;

    static {
        interfaceVersion = new WcaTextField(TOC_INTERFACE_VERSION_LABEL);
        title = new WcaTextField(TOC_TITLE_LABEL);
        notes = new WcaTextField(TOC_NOTES_LABEL);
        author = new WcaTextField(TOC_AUTHOR_LABEL);
        addonVersion = new WcaTextField(TOC_ADDON_VERSION_LABEL);
        mainFileName = new WcaTextField(TOC_FILENAME_LABEL); //TODO Use Filtered Text Field here for filenames
    }

    private JPanel myRoot;

    public WcaMiddleConfigPanel() {
        super(new BorderLayout());

        Border emptyBorder = JBUI.Borders.customLine(JBUI.CurrentTheme.ToolWindow.headerBorderBackground(), 0);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(emptyBorder, TOC_DESC,
                TitledBorder.CENTER, TitledBorder.BELOW_TOP, JBUI.CurrentTheme.ToolWindow.headerFont().deriveFont(24.0F));
        myRoot.setBorder(titledBorder);

        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL,
                null, 0, 0);
        addComponentToPanel(myRoot, interfaceVersion, TOC_INTERFACE_VERSION_LABEL, TOC_INTERFACE_DESC, gbc);
        addComponentToPanel(myRoot, title, TOC_TITLE_LABEL, TOC_TITLE_DESC, gbc);
        addComponentToPanel(myRoot, notes, TOC_NOTES_LABEL, TOC_NOTES_DESC, gbc);
        addComponentToPanel(myRoot, author, TOC_AUTHOR_LABEL, TOC_AUTHOR_DESC, gbc);
        addComponentToPanel(myRoot, addonVersion, TOC_ADDON_VERSION_LABEL, TOC_VERSION_DESC, gbc);
        addComponentToPanel(myRoot, mainFileName, TOC_FILENAME_LABEL, TOC_FILENAME_DESC, gbc);
        myRoot.setSize(getSize());

        add(myRoot, BorderLayout.CENTER);
    }

    private void addComponentToPanel(JPanel panel, JComponent component, String label, String description, GridBagConstraints gbc) {
        ComponentPanelBuilder panelBuilder = new ComponentPanelBuilder(component).withLabel(label).withComment(description);

        panelBuilder.addToPanel(panel, gbc);
    }

    public String getInterfaceVersion() {
        return interfaceVersion.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getNotes() {
        return notes.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getAddonVersion() {
        return addonVersion.getText();
    }

    public String getFileName() {
        return mainFileName.getText();
    }

}