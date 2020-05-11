package com.dumontsean.wow.addon.plugin.wizard;

import com.dumontsean.wow.addon.plugin.config.WcaMiddleConfigPanel;
import com.dumontsean.wow.addon.plugin.module.WcaModuleBuilder;
import com.dumontsean.wow.addon.plugin.objects.TocFile;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.text.StringUtil;

import javax.swing.*;

import static com.dumontsean.wow.addon.plugin.utils.MessagesUtil.*;

public class WcaMiddleModuleWizardStep extends ModuleWizardStep {
    private final WcaMiddleConfigPanel configPanel = new WcaMiddleConfigPanel();
    private WcaModuleBuilder wcaModuleBuilder;

    public WcaMiddleModuleWizardStep(WcaModuleBuilder builder) {
        this.wcaModuleBuilder = builder;
    }

    @Override
    public JComponent getComponent() {
        return configPanel;
    }

    @Override
    public boolean validate() throws ConfigurationException {
        if (StringUtil.isEmptyOrSpaces(configPanel.getInterfaceVersion())) {
            throw new ConfigurationException(getFieldError(TOC_INTERFACE_VERSION_LABEL));
        } else if (StringUtil.isEmptyOrSpaces(configPanel.getTitle())) {
            throw new ConfigurationException(getFieldError(TOC_TITLE_LABEL));
        } else if (StringUtil.isEmptyOrSpaces(configPanel.getAuthor())) {
            throw new ConfigurationException(getFieldError(TOC_AUTHOR_LABEL));
        } else if (StringUtil.isEmptyOrSpaces(configPanel.getAddonVersion())) {
            throw new ConfigurationException(getFieldError(TOC_ADDON_VERSION_LABEL));
        }
        return super.validate();
    }

    @Override
    public void updateDataModel() {
        String fileName = configPanel.getFileName();
        if (StringUtil.isEmptyOrSpaces(fileName))
            fileName = configPanel.getTitle();

        String notes = configPanel.getNotes();
        if (StringUtil.isEmptyOrSpaces(notes))
            notes = "None";
        wcaModuleBuilder.setTocFile(new TocFile(configPanel.getInterfaceVersion(), configPanel.getTitle(),
                notes, configPanel.getAuthor(), configPanel.getAddonVersion(), fileName));
    }


}
