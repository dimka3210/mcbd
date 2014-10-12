package ru.dimka3210.mcbd.models;

import ru.dimka3210.mcbd.lib.Clipboard;
import ru.dimka3210.mcbd.mainframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dimka3210 on 11.10.14.
 * Support <dimka3210@gmail.com>
 */
public class TrayMenuItemModel extends MenuItem {
    private static MenuItem closeItem = null;

    /**
     * @param mainThread синхронизируемся с основным потоком для закрытия программы
     * @return MenuItem
     */
    public static MenuItem getCloseItem(final Thread mainThread) {
        if (closeItem != null) {
            return closeItem;
        }

        MenuItem menuItem = new MenuItem("Выход");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (mainThread) {
                    System.exit(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        return closeItem = menuItem;
    }

    /**
     * Показавть окно программы
     *
     * @return MenuItem
     */
    public static MenuItem getShowFrameItem() {
        MenuItem menuItem = new MenuItem("Показать окно настроек");
        menuItem.addActionListener(getShowFrameListener());
        return menuItem;
    }

    public static ActionListener getShowFrameListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (this) {
                    MainFrame.getInstance().setVisible(true);
                }
            }
        };
    }

    public static ArrayList<MenuItem> getWordItems() throws Exception {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();

        for (final ItemModel item : ItemModel.getAll()) {
            MenuItem menuItem = new MenuItem(item.getKey());
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clipboard.addString(item.getValue());
                }
            });
            items.add(menuItem);
        }

        return items;
    }
}
