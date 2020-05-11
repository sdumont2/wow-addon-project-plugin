package com.dumontsean.wow.addon.plugin.module;

import com.dumontsean.wow.addon.plugin.constants.WcaIcons;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class WcaModule extends ModuleType<WcaModuleBuilder> {

    private static final String ID = "WCA_MODULE";

    public WcaModule() {
        super(ID);
    }

    @NotNull
    @Override
    public WcaModuleBuilder createModuleBuilder() {
        return new WcaModuleBuilder();
    }

    @NotNull //Todo i18 these?
    @Override
    public String getName() {
        return "World of Warcraft Classic Addon";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Add support for World of Warcraft Classic Addon Project Generation";
    }

    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return WcaIcons.SmallWcaIcon;
    }

    @NotNull
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext,
                                                @NotNull WcaModuleBuilder moduleBuilder,
                                                @NotNull ModulesProvider modulesProvider) {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }

    public static WcaModule getInstance() {
        return (WcaModule) ModuleTypeManager.getInstance().findByID(ID);
    }
}
