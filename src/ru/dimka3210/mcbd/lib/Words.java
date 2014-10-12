package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.models.LogModel;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by dimka3210 on 10.10.14.
 * Support <dimka3210@gmail.com>
 */
public class Words {
    private File wordsFile = null;
    private Properties properties = null;

    private static Words ourInstance = new Words();

    public static Words getInstance() {
        return ourInstance;
    }

    private Words() {
        wordsFile = Tools.getWordsFile();
        properties = new Properties();
    }

    public String get(String keyword) {
        load();
        return properties.getProperty(keyword);
    }

    public Set<String> load() {
        try {
            properties.loadFromXML(new FileInputStream(wordsFile));
        } catch (IOException e) {
            LogModel.add(e.getMessage());
        }
        return properties.stringPropertyNames();
    }

    public void add(String keyword, String value) {
        load();
        properties.setProperty(keyword, value);
        try {
            properties.storeToXML(new FileOutputStream(wordsFile), keyword);
        } catch (IOException e) {
            LogModel.add(e.getMessage());
        }
    }

    public void del(String dropKey) {
        load();
        properties.remove(dropKey);
        try {
            properties.storeToXML(new FileOutputStream(wordsFile), "");
        } catch (FileNotFoundException e) {
            LogModel.add(e.getMessage());
        } catch (IOException e) {
            LogModel.add(e.getMessage());
        }

    }
}
