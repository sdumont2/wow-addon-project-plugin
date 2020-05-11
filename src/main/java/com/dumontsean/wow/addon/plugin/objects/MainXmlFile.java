package com.dumontsean.wow.addon.plugin.objects;

public class MainXmlFile {
    private String addonName;

    public MainXmlFile(String addonName) {
        this.addonName = addonName;
    }

    public String getXmlFileText() {
        StringBuilder sb = new StringBuilder();

        sb.append("<Ui xmlns=\"http://www.blizzard.com/wow/ui/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.blizzard.com/wow/ui/ ..\\FrameXML\\UI.xsd\">\n\n");
            sb.append("\t<Include file=\"Libs\\Libs.xml\"/>\n");
            sb.append("\t<Script file=\"src\\").append(addonName).append(".lua\"/>\n\n");
            sb.append("\t<!-- Add Any Additional Files/Configuration Here -->\n");
        sb.append("\n</UI>");

        return sb.toString();
    }
}
