package com.dumontsean.wow.addon.plugin.objects;

import com.dumontsean.wow.addon.plugin.utils.MessagesUtil;
import com.intellij.openapi.options.ConfigurationException;

public class ReadmeFile {

    public static final String fileName = "README.md";

    private String addonName;
    private boolean includedAce;

    public ReadmeFile(String addonName, boolean includedAce) {
        this.addonName = addonName;
        this.includedAce = includedAce;
    }

    public String getReadMeText() {
        return MessagesUtil.getLocalizedReadMeText(addonName, includedAce);
    }

    public boolean createFileAtPath(String path) throws ConfigurationException {
        boolean success = false;

        try {

        } catch (Exception e) {
            throw new ConfigurationException("Unable to create README.md at path: " + path);
        }

        return success;
    }

}
