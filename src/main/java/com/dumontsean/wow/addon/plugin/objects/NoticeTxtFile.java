package com.dumontsean.wow.addon.plugin.objects;

import com.dumontsean.wow.addon.plugin.utils.MessagesUtil;

public class NoticeTxtFile {

    public static final String fileName = "NOTICE.txt";

    public String getFileText(String addonName, String projectName, boolean includedAce) {
        return MessagesUtil.getLocalizedNoticeText(addonName, projectName, includedAce);
    }
}
