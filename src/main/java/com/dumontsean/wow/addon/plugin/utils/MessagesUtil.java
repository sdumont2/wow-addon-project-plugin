package com.dumontsean.wow.addon.plugin.utils;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

public class MessagesUtil {

    public static final String PROJECT_HEADER = message("ui.main.header");
    public static final String PROJECT_DESCRIPTION = message("ui.main.desc");

    public static final String TOC_DESC = message("ui.toc.description");
    public static final String TOC_INTERFACE_VERSION_LABEL = message("ui.toc.interfaceVersionLabel");
    public static final String TOC_INTERFACE_DESC = message("ui.toc.interfaceVersionDesc");
    public static final String TOC_TITLE_LABEL = message("ui.toc.titleLabel");
    public static final String TOC_TITLE_DESC = message("ui.toc.titleDesc");
    public static final String TOC_NOTES_LABEL = message("ui.toc.notesLabel");
    public static final String TOC_NOTES_DESC = message("ui.toc.notesDesc");
    public static final String TOC_AUTHOR_LABEL = message("ui.toc.authorLabel");
    public static final String TOC_AUTHOR_DESC = message("ui.toc.authorDesc");
    public static final String TOC_ADDON_VERSION_LABEL = message("ui.toc.addonVersionLabel");
    public static final String TOC_VERSION_DESC = message("ui.toc.addonVersionDesc");
    public static final String TOC_FILENAME_LABEL = message("ui.toc.mainFileNameLabel");
    public static final String TOC_FILENAME_DESC = message("ui.toc.mainFileNameDesc");

    public static final String LIB_DESC = message("ui.libs.description");
    public static final String LIB_WOW_VERSION_LABEL = message("ui.libs.wowVersionLabel");
    public static final String LIB_WOW_VERSION_DESC = message("ui.libs.wowVersionDesc");
    public static final String LIB_LOCATION_LABEL = message("ui.libs.locationLabel");
    public static final String LIB_LOCATION_DESC = message("ui.libs.locationDesc");
    public static final String LIB_ACE_LABEL = message("ui.libs.includeAceLabel");
    public static final String LIB_ACE_DESC = message("ui.libs.includeAceDesc");

    private static final String README_TEXT_MAIN = message("readme.text");
    private static final String README_TEXT_ACE = message("readme.includedAce");

    private static final String NOTICE_TEXT = message("notice.text");

    private static final String FIELD_ERROR = message("error.fieldValue");

    public static String getFieldError(String field){
        return String.format(FIELD_ERROR, field);
    }

    public static String getLocalizedReadMeText(String addonName, boolean includedAce) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(README_TEXT_MAIN, addonName));
        if(includedAce)
            sb.append(README_TEXT_ACE);
        return sb.toString();
    }

    public static String getLocalizedNoticeText(String addonName, String projectName, boolean includedAce) {
        return String.format(NOTICE_TEXT, addonName, projectName);
    }


    private static Reference<ResourceBundle> wcaBundle;
    @NonNls
    private static final String BUNDLE = "messages.messages";

    private MessagesUtil() {
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = com.intellij.reference.SoftReference.dereference(wcaBundle);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            wcaBundle = new SoftReference<>(bundle);
        }
        return bundle;
    }

    private static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }
}
