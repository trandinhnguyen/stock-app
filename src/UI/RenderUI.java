package UI;

import seach.Answer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RenderUI extends JFrame {

    private JPanel mainFrame;
    private JButton tag1, tag2, tag3, tag4, tag5, search;
    private JTextArea text;


    public RenderUI() {
        createJFrame();
    }

    public void actionPerformed(ActionEvent e) {
        Answer action = new Answer();
        if (e.getActionCommand() == tag1.getText()) {
            text.setText(null);
            text.append(action.getSearch(tag1.getText()));
        }
        if (e.getActionCommand() == tag2.getText()) {
            text.setText(null);
            text.append(action.getSearch(tag2.getText()));
        }
        if (e.getActionCommand() == tag3.getText()) {
            text.setText(null);
            text.append(action.getSearch(tag3.getText()));
        }
        if (e.getActionCommand() == tag4.getText()) {
            text.setText(null);
            text.append(action.getSearch(tag4.getText()));
        }
        if (e.getActionCommand() == tag5.getText()) {
            text.setText(null);
            text.append(action.getSearch(tag5.getText()));
        }
    }

    private void createJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(900, 600);
        this.setLocationRelativeTo(null);
        mainFrame = createMainFrame();
        this.add(mainFrame);
    }


    private JPanel createMainFrame() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(buttonPanel(), BorderLayout.WEST);
        panel.add(searchPanel(), BorderLayout.NORTH);
        panel.add(textPanel(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        panel.setBackground(Color.green);

        tag1 = new JButton("tag1");
        tag2 = new JButton("tag2");
        tag3 = new JButton("tag1");
        tag4 = new JButton("tag1");
        tag5 = new JButton("tag1");

//        tag1.addActionListener(this);
//        tag2.addActionListener(this);
//        tag3.addActionListener(this);
//        tag4.addActionListener(this);
//        tag5.addActionListener(this);


        panel.add(tag1);
        panel.add(tag2);
        panel.add(tag3);
        panel.add(tag4);
        panel.add(tag5);

        return panel;
    }

    private JPanel searchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 100, 15, 30));
        GridBagConstraints grb = new GridBagConstraints();
        grb.gridx = 0;
        grb.gridy = 0;
        grb.ipady = 4;
        JTextField textsearch = new JTextField(40);
        search = new JButton("SEARCH");

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Answer answer = new Answer();
                text.setText(answer.getSearch(textsearch.getText()));
            }
        });

        panel.add(search, grb);
        grb.gridx = 1;
        grb.ipadx = 100;
        grb.ipady = 10;
        panel.add(textsearch, grb);
        return panel;
    }

    private JPanel textPanel() {
        JPanel panel = new JPanel();
        text = new JTextArea(40, 70);
        panel.add(text);
        return panel;
    }

}