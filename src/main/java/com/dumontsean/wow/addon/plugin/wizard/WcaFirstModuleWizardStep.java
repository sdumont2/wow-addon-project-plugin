package com.dumontsean.wow.addon.plugin.wizard;

import com.dumontsean.wow.addon.plugin.config.WcaFirstConfigPanel;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;

import javax.swing.*;

public class WcaFirstModuleWizardStep extends ModuleWizardStep {
    private final WcaFirstConfigPanel configPanel = new WcaFirstConfigPanel();

    @Override
    public JComponent getComponent() {
        return configPanel;
    }

    @Override
    public void updateDataModel() {

    }

    @Override
    public boolean validate() throws ConfigurationException {
        return super.validate();
    }
}