package ru.dimka3210.mcbd.models;

import ru.dimka3210.mcbd.lib.Tools;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

/**
 * Created by dimka3210 on 11.10.14.
 * Support <dimka3210@gmail.com>
 */
public class LogModel {
    public static void add(String text) {
        try {
            File logFile = new File(Tools.getWorkPath() + "/application.log");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(logFile, true);
            String date = Calendar.getInstance().getTime().toString();
            String message = "[" + date + "] " + text + "\n\n";
            fileWriter.write(message);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
