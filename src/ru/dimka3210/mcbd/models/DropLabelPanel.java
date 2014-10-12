package ru.dimka3210.mcbd.models;

import ru.dimka3210.mcbd.lib.Tools;
import ru.dimka3210.mcbd.lib.TrayMenu;
import ru.dimka3210.mcbd.lib.Words;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by dimka3210 on 11.10.14.
 * Support <dimka3210@gmail.com>
 */
public class DropLabelPanel extends JLabel {
    Icon icon;
    JPanel parentPanel;

    public DropLabelPanel(Icon icon, final ItemPanelModel keywordPanel, final JPanel parentPanel) {
        super(icon);
        this.icon = icon;
        this.parentPanel = parentPanel;

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentPanel.remove(keywordPanel);
                parentPanel.revalidate();
                parentPanel.repaint();

                String dropKey = keywordPanel.getKey();
                Words.getInstance().del(dropKey);

                try {
                    Tools.getTrayMenu().paintItems(Thread.currentThread());
                } catch (Exception exception) {
                    LogModel.add(exception.getMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}