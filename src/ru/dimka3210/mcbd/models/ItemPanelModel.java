package ru.dimka3210.mcbd.models;

import javax.swing.*;

/**
 * Created by dimka3210 on 21.09.14.
 * Support <dimka3210@gmail.com>
 */
public class ItemPanelModel extends JPanel {
    private String key;
    private String value;

    public ItemPanelModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
