package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.mainframe.MainFrame;
import ru.dimka3210.mcbd.models.ItemModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dimka3210 on 16.09.14.
 * Support <dimka3210@gmail.com>
 */
public class TrayMenu extends PopupMenu {
    public TrayMenu() throws HeadlessException {
        MenuItem showMainFrameItem = new MenuItem("Показать окно настроек");
        MenuItem exitItem = new MenuItem("Закрыть программу");
        showMainFrameItem.addActionListener(item1Listener());
        exitItem.addActionListener(item2Listener());

        try {
            for (final ItemModel item : ItemModel.getAll()) {
                MenuItem _item = new MenuItem(item.getKey());
                _item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clipboard.addString(item.getValue());
                    }
                });
                this.add(_item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.addSeparator();
        this.add(showMainFrameItem);
        this.add(exitItem);
    }

    public ActionListener item1Listener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (this) {
                    MainFrame.getInstance().setVisible(true);
                }
            }
        };
    }

    public ActionListener item2Listener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }
}
