package ru.dimka3210.mcbd.mainframe;

import ru.dimka3210.mcbd.lib.Tools;
import ru.dimka3210.mcbd.models.ItemModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by dimka3210 on 20.09.14.
 * Support <dimka3210@gmail.com>
 */
public class MainFrameComponentsListener {
    final MainFrame frame;

    public MainFrameComponentsListener(MainFrame frame) {
        this.frame = frame;
        toggleCheckbox(frame.hideCheckBox.isSelected());
    }

    public ActionListener checkboxListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                toggleCheckbox(checkBox.isSelected());
            }
        };
    }

    private void toggleCheckbox(boolean isPassword) {
        String value;

        if (isPassword) {
            value = frame.textField.getText();
            frame.passwordField.setText(value);
            frame.textField.setText("");
        } else {
            value = String.copyValueOf(frame.passwordField.getPassword());
            frame.textField.setText(value);
            frame.passwordField.setText("");
        }

        frame.passwordField.setEnabled(isPassword);
        frame.textField.setEnabled(!isPassword);
    }

    public ActionListener okButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = frame.keywordField.getText();
                String value = frame.textField.getText();
                boolean isPrivate = frame.hideCheckBox.isSelected();
                keyword = (isPrivate) ? "_" + keyword : keyword;

                Properties properties = new Properties();
                try {
                    properties.loadFromXML(new FileInputStream(Tools.getWordsFile()));
                    properties.setProperty(keyword, value);
                    properties.storeToXML(new FileOutputStream(Tools.getWordsFile()), keyword);
                    MainFrame.getInstance().drawItems(ItemModel.getAll());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
    }
}