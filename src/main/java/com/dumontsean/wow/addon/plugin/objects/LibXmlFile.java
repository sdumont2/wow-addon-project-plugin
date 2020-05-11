package com.dumontsean.wow.addon.plugin.objects;

public class LibXmlFile {

    public static final String fileName = "Libs.xml";

    public static String getFileText(boolean includedAce){
        StringBuilder sb = new StringBuilder();

        sb.append("<Ui xmlns=\"http://www.blizzard.com/wow/ui/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.blizzard.com/wow/ui/ ..\\FrameXML\\UI.xsd\">\n\n");
        if(includedAce) {
            sb.append("\t<Script file=\"Ace3\\LibStub\\LibStub.lua\"/>\n");
            sb.append("\t<Include file=\"Ace3\\CallbackHandler-1.0\\CallbackHandler-1.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceAddon-3.0\\AceAddon-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceEvent-3.0\\AceEvent-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceTimer-3.0\\AceTimer-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceBucket-3.0\\AceBucket-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceHook-3.0\\AceHook-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceDB-3.0\\AceDB-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceDBOptions-3.0\\AceDBOptions-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceLocale-3.0\\AceLocale-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceConsole-3.0\\AceConsole-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceGUI-3.0\\AceGUI-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceConfig-3.0\\AceConfig-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceComm-3.0\\AceComm-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceTab-3.0\\AceTab-3.0.xml\"/>\n");
            sb.append("\t<Include file=\"Ace3\\AceSerializer-3.0\\AceSerializer-3.0.xml\"/>\n");
        }
            sb.append("\t<!-- Add Any Additional Libraries Here -->\n");
        sb.append("\n</UI>");

        return sb.toString();
    }
}