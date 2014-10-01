package ru.dimka3210.mcbd.mainframe;

import ru.dimka3210.mcbd.models.ItemModel;
import ru.dimka3210.mcbd.models.ItemPanelModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dimka3210 on 16.09.14.
 * Support <dimka3210@gmail.com>
 */
public class MainFrame extends JFrame {
    MainFrameWindowListener windowListener;
    MainFrameComponentsListener componentsListener;
    MainFrameMouseListener mouseListener;
    private static MainFrame instance = null;
    protected JPanel mainPanel;
    protected JPanel listPane;
    protected JTextField textField;
    protected JCheckBox hideCheckBox;
    protected JButton okButton;
    protected JButton resetButton;
    protected JPasswordField passwordField;
    protected JTextField keywordField;
    protected JPanel actionsPane;
    protected JPanel wordsPanel;
    protected ArrayList<ItemModel> items = new ArrayList<ItemModel>();

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        for (int i = 0; i < 50; i++) {
            items.add(new ItemModel("hello" + i, "Привет " + i, new Random().nextBoolean()));
        }

        setTitle("Настройки");
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

        windowListener = new MainFrameWindowListener(this);
        componentsListener = new MainFrameComponentsListener(this);

        addWindowListener(windowListener);
        hideCheckBox.addActionListener(componentsListener.checkboxListener());
        okButton.addActionListener(componentsListener.okButtonListener());
    }

    private void createUIComponents() throws Exception {
        mouseListener = new MainFrameMouseListener(this);
        wordsPanel = new JPanel();
        wordsPanel.setLayout(new BoxLayout(wordsPanel, BoxLayout.Y_AXIS));
//        wordsPanel.setDoubleBuffered(true);
        drawItems(ItemModel.getAll());
    }

    public void drawItems(ArrayList<ItemModel> items) {
        wordsPanel.removeAll();

        LineBorder border = new LineBorder(new Color(48, 44, 173));

        for (ItemModel item : items) {
            ItemPanelModel keywordPanel = new ItemPanelModel(item.getKey(), item.getValue());
            keywordPanel.setLayout(new BorderLayout());
            JLabel keywordLabel = new JLabel(item.getKey());
            JLabel valueLabel = new JLabel(item.getValue());
            Dimension oldSize = keywordLabel.getSize();
            keywordPanel.setSize(new Dimension(wordsPanel.getWidth(), oldSize.height));
            keywordPanel.add(keywordLabel, BorderLayout.WEST);
            keywordPanel.add(valueLabel, BorderLayout.EAST);
            keywordPanel.addMouseListener(mouseListener.getItemsListener());
            keywordPanel.setBorder(border);
            keywordPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            wordsPanel.add(keywordPanel);
            wordsPanel.updateUI();
        }
    }
}
