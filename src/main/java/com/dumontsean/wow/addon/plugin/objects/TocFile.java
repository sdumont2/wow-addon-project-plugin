package com.dumontsean.wow.addon.plugin.objects;

public class TocFile {

    private String interfaceVersion, title, notes, author, addonVersion, mainFileNameAndLocation;

    public TocFile(String interfaceVersion, String title, String notes, String author, String addonVersion, String mainFileNameAndLocation) {
        this.interfaceVersion = interfaceVersion;
        this.title = title;
        this.notes = notes;
        this.author = author;
        this.addonVersion = addonVersion;
        this.mainFileNameAndLocation = mainFileNameAndLocation;
    }

    public String getFileText(){
        return String.format(
                "## Interface: %s\n" +
                "## Title: %s\n" +
                "## Notes: %s\n" +
                "## Author: %s\n" +
                "## Version: %s\n" +
                "\n" +
                "%s",
                interfaceVersion, title, notes, author, addonVersion, mainFileNameAndLocation
        );
    }

    public String getMainFileNameAndLocation() {
        return mainFileNameAndLocation;
    }

    public void setMainFileNameAndLocation(String mainFileNameAndLocation) {
        this.mainFileNameAndLocation = mainFileNameAndLocation;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddonVersion() {
        return addonVersion;
    }

    public void setAddonVersion(String addonVersion) {
        this.addonVersion = addonVersion;
    }
}
