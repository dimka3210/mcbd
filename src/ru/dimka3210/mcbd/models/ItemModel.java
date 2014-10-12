package ru.dimka3210.mcbd.models;

import ru.dimka3210.mcbd.lib.Words;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class ItemModel {
    String key, value;
    boolean isPrivate = false;

    public ItemModel(String key, String value, boolean isPrivate) {
        this.key = key;
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public ItemModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        if (isPrivate) {
            return "*********";
        }
        return value;
    }

    public String getKey() {
        return key;
    }

    public static ArrayList<ItemModel> getAll() throws Exception {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();

        for (String key : Words.getInstance().load()) {
            items.add(new ItemModel(key, Words.getInstance().get(key)));
        }
        return items;
    }
}
