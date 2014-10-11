package ru.dimka3210.mcbd.lib;

import java.awt.*;
import java.io.File;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class Tools {
    public static String getWorkPath() throws Exception {
        return new File(".").getCanonicalPath();
    }

    public static Image getDefaultIcon() throws Exception {
        System.out.println(Tools.getWorkPath() + "/img/icon.jpg");
        return Toolkit.getDefaultToolkit().getImage(Tools.getWorkPath() + "/img/icon.jpg");
    }

    /**
     * @return File|null
     */
    public static File getWordsFile() {
        File configFile = null;
        try {
            configFile = new File(getWorkPath() + "/words");
            if (!configFile.exists()) {
                configFile.createNewFile();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return configFile;
    }
}
