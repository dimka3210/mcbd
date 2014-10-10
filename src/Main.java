import ru.dimka3210.mcbd.lib.Tools;
import ru.dimka3210.mcbd.lib.TrayMenu;

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
        TrayMenu trayMenu = new TrayMenu(Thread.currentThread());
        TrayIcon trayIcon = new TrayIcon(trayImage, "MultiClipboard", trayMenu);

        trayIcon.setImageAutoSize(true);
        trayIcon.addActionListener(trayMenu.item1Listener());
        tray.add(trayIcon);
    }
}