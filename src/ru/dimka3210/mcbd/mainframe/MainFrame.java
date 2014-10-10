package ru.dimka3210.mcbd.mainframe;

import ru.dimka3210.mcbd.models.ItemModel;
import ru.dimka3210.mcbd.models.ItemPanelModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

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
    protected JButton okButton;
    protected JButton resetButton;
    protected JTextField keywordField;
    protected JPanel actionsPane;
    protected JPanel wordsPanel;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        setTitle("Настройки");
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

        windowListener = new MainFrameWindowListener(this);
        componentsListener = new MainFrameComponentsListener(this);

        addWindowListener(windowListener);
        okButton.addActionListener(componentsListener.okButtonListener());
        resetButton.addActionListener(componentsListener.resetButtonListener());
    }

    private void createUIComponents() throws Exception {
        mouseListener = new MainFrameMouseListener(this);
        wordsPanel = new JPanel();
        wordsPanel.setLayout(new BoxLayout(wordsPanel, BoxLayout.Y_AXIS));
        drawItems(ItemModel.getAll());
    }

    public void drawItems(ArrayList<ItemModel> items) {
        wordsPanel.removeAll();
        LineBorder border = new LineBorder(new Color(144, 153, 173));

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
            wordsPanel.revalidate();
            wordsPanel.repaint();
        }
    }
}
