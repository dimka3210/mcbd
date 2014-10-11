package ru.dimka3210.mcbd.lib;

import ru.dimka3210.mcbd.mainframe.MainFrame;
import ru.dimka3210.mcbd.models.ItemModel;
import ru.dimka3210.mcbd.models.TrayMenuItemModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dimka3210 on 16.09.14.
 * Support <dimka3210@gmail.com>
 */
public class TrayMenu extends PopupMenu {
    public TrayMenu(Thread mainThread) throws HeadlessException {
        this.addSeparator();
        this.add(TrayMenuItemModel.getShowFrameItem());
        this.add(TrayMenuItemModel.getCloseItem(mainThread));
    }
}
