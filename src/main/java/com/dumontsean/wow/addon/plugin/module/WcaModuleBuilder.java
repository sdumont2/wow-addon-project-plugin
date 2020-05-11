package com.dumontsean.wow.addon.plugin.module;

import com.dumontsean.wow.addon.plugin.constants.WcaIcons;
import com.dumontsean.wow.addon.plugin.objects.ReadmeFile;
import com.dumontsean.wow.addon.plugin.objects.TocFile;
import com.dumontsean.wow.addon.plugin.wizard.WcaFirstModuleWizardStep;
import com.dumontsean.wow.addon.plugin.wizard.WcaLastModuleWizardStep;
import com.dumontsean.wow.addon.plugin.wizard.WcaMiddleModuleWizardStep;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleBuilderListener;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.ProjectJdkTable;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WcaModuleBuilder extends ModuleBuilder implements ModuleBuilderListener {

    private static Logger logger = Logger.getLogger(WcaModuleBuilder.class);

    private TocFile tocFile;
    private boolean includeAce;
    private String sdkPath;
    private String wowVersion;

    public WcaModuleBuilder() {
        addListener(this);
    }

    @Override
    public String getBuilderId(){
        return "wca";
    }

    @Override
    public Icon getNodeIcon() {
        return WcaIcons.SmallWcaIcon;
    }

    //TODO i18 these?
    @Override
    public String getDescription() {
        return "WoW Classic Addon Module";
    }

    @Override
    public String getGroupName(){
        return "wca";
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new WcaMiddleModuleWizardStep(this), new WcaLastModuleWizardStep(this)};
    }

    @Override
    public void moduleCreated(@NotNull Module module) {
        //Create the files.
        String basePath = getContentEntryPath();


    }

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel rootModel) {
        ContentEntry contentEntry = doAddContentEntry(rootModel);

        if(contentEntry != null) {
            List<String> paths = getSourcePaths();

            for(String path : paths) {
                new File(path).mkdirs();
                VirtualFile sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(path));

                if(sourceRoot != null) {
                    contentEntry.addSourceFolder(sourceRoot, false, "");
                }
            }
        }

        Project project = rootModel.getProject();
        ProjectJdkTable table = ProjectJdkTable.getInstance();
        logger.error("The Table is: " + table);
        String basePath = getContentEntryPath();
        String readmeFilePath = FileUtil.findFileInProvidedPath(basePath, ReadmeFile.fileName);
        ReadmeFile readmeFile = new ReadmeFile(tocFile.getTitle(), includeAce);


    }

    private List<String> getSourcePaths() {
        List<String> paths = new ArrayList<>();

        String path = getContentEntryPath() + File.separator + "src";
        new File(path).mkdirs();
        paths.add(path);

        return paths;
    }

    @Nullable
    @Override //This is the First Step in the wizard. Just want to provide information rather than collect
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new WcaFirstModuleWizardStep();
    }

    public void setTocFile(TocFile tocFile) {
        this.tocFile = tocFile;
    }

    public void setIncludeAce(boolean includeAce) {
        this.includeAce = includeAce;
    }

    public void setSdkPath(String sdkPath) {
        this.sdkPath = sdkPath;
    }

    public void setWoWVersion(String wowVersion) {
        this.wowVersion = wowVersion;
    }

    @Override
    public ModuleType getModuleType() {
        return WcaModule.getInstance();
    }
}
