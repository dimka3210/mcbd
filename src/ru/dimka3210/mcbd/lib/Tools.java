package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.models.LogModel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class Tools {
    private static TrayMenu trayMenu;

    /**
     * Получить рабочую директорию
     * @return String
     */
    public static String getWorkPath() {
        File tmpFile;
        String path = "";
        try {
            tmpFile = new File(".");
            path = tmpFile.getCanonicalPath();
        } catch (IOException e) {
            LogModel.add(e.getMessage());
        }
        return path;
    }

    public static Image getDefaultIcon() throws Exception {
        return Toolkit.getDefaultToolkit().getImage(Tools.getWorkPath() + "/img/icon.jpg");
    }

    /**
     * @return File|null
     */
    public static File getWordsFile() {
        File wordsFile = null;
        try {
            wordsFile = new File(getWorkPath() + "/words");
            if (!wordsFile.exists()) {
                wordsFile.createNewFile();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordsFile;
    }

    /**
     * @param menu TrayMenu
     */
    public static void setTrayMenu(TrayMenu menu) {
        trayMenu = menu;
    }

    /**
     * @return TrayMenu
     */
    public static TrayMenu getTrayMenu(){
        return trayMenu;
    }
}
