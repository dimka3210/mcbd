import ru.dimka3210.mcbd.lib.Tools;
import ru.dimka3210.mcbd.lib.TrayMenu;
import ru.dimka3210.mcbd.mainframe.MainFrameComponentsListener;
import ru.dimka3210.mcbd.models.TrayMenuItemModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (!SystemTray.isSupported()) {
            JOptionPane.showMessageDialog(null, "Системный трей не поддерживается", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        }

        SystemTray tray = SystemTray.getSystemTray();
        Image trayImage = Tools.getDefaultIcon();
        Tools.setTrayMenu(new TrayMenu(Thread.currentThread()));

        TrayIcon trayIcon = new TrayIcon(trayImage, "MultiClipboard", Tools.getTrayMenu());
        trayIcon.setImageAutoSize(true);
        trayIcon.addActionListener(TrayMenuItemModel.getShowFrameListener());
        tray.add(trayIcon);
    }
}