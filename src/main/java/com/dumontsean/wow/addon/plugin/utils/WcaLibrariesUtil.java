package com.dumontsean.wow.addon.plugin.utils;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.download.DownloadableFileDescription;
import com.intellij.util.download.DownloadableFileService;
import com.intellij.util.download.FileDownloader;
import com.intellij.openapi.util.Pair;
import com.intellij.util.io.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WcaLibrariesUtil {

    public static boolean downloadWoWClassicUISourceToPath(String path) {
        return downloadItemToPath(path, "https://github.com/Gethe/wow-ui-source/archive/classic.zip", "classic.zip");
    }

    public static boolean downloadWoWLiveUISourceToPath(String path) {
        return downloadItemToPath(path, "https://github.com/Gethe/wow-ui-source/archive/live.zip", "live.zip");
    }

    public static boolean downloadWoWApiDocsToPath(String path) {
        return downloadItemToPath(path, "https://github.com/Ellypse/IntelliJ-IDEA-Lua-IDE-WoW-API/archive/master.zip", "master.zip");
    }

    public static boolean downloadAceToPath(String path) {
        return downloadItemToPath(path, "https://www.wowace.com/projects/ace3/files/latest", "Ace3.zip");
    }

    private static boolean downloadItemToPath(String path, String url, String fileName) {
        boolean success = false;

        try {
            VirtualFile virtualDir = VfsUtil.createDirectoryIfMissing(path);
            if (virtualDir != null) {
                File dir = VfsUtil.virtualToIoFile(virtualDir);
                DownloadableFileService fileService = DownloadableFileService.getInstance();
                DownloadableFileDescription fileDescription = fileService.createFileDescription(url, fileName);
                FileDownloader downloader = fileService.createDownloader(Collections.singletonList(fileDescription), fileName);
                List<Pair<File, DownloadableFileDescription>> files = downloader.download(dir);
                if (files.size() > 0) {
                    ZipUtil.extract(files.get(0).getFirst(), dir, null);
                    success = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return success;
    }
}
