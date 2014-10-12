package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.models.TrayMenuItemModel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dimka3210 on 16.09.14.
 * Support <dimka3210@gmail.com>
 */
public class TrayMenu extends PopupMenu {
    public TrayMenu(Thread mainThread) throws Exception {
        paintItems(mainThread);
    }

    public void paintItems(Thread mainThread) throws Exception {
        this.removeAll();

        ArrayList<MenuItem> wordItems = TrayMenuItemModel.getWordItems();
        for (MenuItem item : wordItems) {
            this.add(item);
        }

        if (wordItems.size() > 0) {
            this.addSeparator();
        }

        this.add(TrayMenuItemModel.getShowFrameItem());
        this.add(TrayMenuItemModel.getCloseItem(mainThread));
    }
}
