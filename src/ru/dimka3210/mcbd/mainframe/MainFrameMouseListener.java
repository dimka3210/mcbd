package ru.dimka3210.mcbd.mainframe;

import ru.dimka3210.mcbd.models.ItemPanelModel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class MainFrameMouseListener {
    final MainFrame frame;

    public MainFrameMouseListener(MainFrame frame) {
        this.frame = frame;
    }

    public MouseListener getItemsListener(){
        return new MouseListener() {
            Color defaultBackground = null;
            Color hoverBackground = new Color(0x4DB3FF);

            @Override
            public void mouseClicked(MouseEvent e) {
                ItemPanelModel panel = (ItemPanelModel) e.getSource();
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(panel.getValue()), new ClipboardOwner() {
                    @Override
                    public void lostOwnership(Clipboard clipboard, Transferable contents) {}
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JPanel panel = (JPanel) e.getSource();
                defaultBackground = panel.getBackground();
                panel.setBackground(hoverBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JPanel panel = (JPanel) e.getSource();
                panel.setBackground(defaultBackground);
            }
        };
    }
}
