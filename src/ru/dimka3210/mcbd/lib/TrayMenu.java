package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.mainframe.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by dimka3210 on 16.09.14.
 * Support <dimka3210@gmail.com>
 */
public class TrayMenu extends PopupMenu {
    public TrayMenu() throws HeadlessException {
        MenuItem item1 = new MenuItem("Показать окно настроек");
        MenuItem item2 = new MenuItem("Закрыть программу");

        item1.addActionListener(item1Listener());
        item2.addActionListener(item2Listener());

        this.add(item1);
        this.add(item2);
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
