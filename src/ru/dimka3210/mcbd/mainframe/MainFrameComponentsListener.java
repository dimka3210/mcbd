package ru.dimka3210.mcbd.mainframe;

import ru.dimka3210.mcbd.lib.Tools;
import ru.dimka3210.mcbd.lib.TrayMenu;
import ru.dimka3210.mcbd.lib.Words;
import ru.dimka3210.mcbd.models.ItemModel;
import ru.dimka3210.mcbd.models.LogModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class MainFrameComponentsListener {
    final MainFrame frame;

    public MainFrameComponentsListener(MainFrame frame) {
        this.frame = frame;
    }

    public ActionListener okButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = frame.keywordField.getText();
                String value = frame.textField.getText();
                try {
                    Words.getInstance().add(keyword, value);
                    MainFrame.getInstance().drawItems(ItemModel.getAll());
                    Tools.getTrayMenu().paintItems(Thread.currentThread());
                } catch (Exception mainFrameException) {
                    LogModel.add(mainFrameException.getMessage());
                }
            }
        };
    }

    public ActionListener resetButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String emptyString = "";
                frame.textField.setText(emptyString);
                frame.keywordField.setText(emptyString);
            }
        };
    }
}