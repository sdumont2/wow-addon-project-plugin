package com.dumontsean.wow.addon.plugin.wizard;

import com.dumontsean.wow.addon.plugin.config.WcaLastConfigPanel;
import com.dumontsean.wow.addon.plugin.module.WcaModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.text.StringUtil;

import javax.swing.*;

import static com.dumontsean.wow.addon.plugin.utils.MessagesUtil.*;

public class WcaLastModuleWizardStep extends ModuleWizardStep {
    private final WcaLastConfigPanel configPanel = new WcaLastConfigPanel();
    private WcaModuleBuilder wcaModuleBuilder;

    public WcaLastModuleWizardStep(WcaModuleBuilder builder) {
        this.wcaModuleBuilder = builder;
    }

    @Override
    public JComponent getComponent() {
        return configPanel;
    }

    @Override
    public void updateDataModel() {
        wcaModuleBuilder.setIncludeAce(configPanel.includeAce());
        wcaModuleBuilder.setSdkPath(configPanel.getLibsPath());
        wcaModuleBuilder.setWoWVersion(configPanel.getWowVersion());
    }

    @Override
    public boolean validate() throws ConfigurationException {
        // TODO Make the library path Optional Later.
        if (StringUtil.isEmptyOrSpaces(configPanel.getWowVersion())) {
            throw new ConfigurationException(getFieldError(LIB_WOW_VERSION_LABEL));
        } else if (StringUtil.isEmptyOrSpaces(configPanel.getLibsPath())) {
            throw new ConfigurationException(getFieldError(LIB_LOCATION_LABEL));
        }
        return super.validate();
    }
}
