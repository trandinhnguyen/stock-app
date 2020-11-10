package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RenderUI extends JFrame {

    private JPanel mainFrame;

    public RenderUI() {
        createJFrame();
    }



    private void createJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        mainFrame = createMainFrame();
        add(mainFrame);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainFrame() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(buttonPanel(), BorderLayout.WEST);
        panel.add(searchPanel(), BorderLayout.NORTH);
        panel.add(textPanel(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new GridLayout(5,1,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        panel.setBackground(Color.green);

        JButton tag1 = new JButton("tag1");
        JButton tag2 = new JButton("tag2");
        JButton tag3 = new JButton("tag1");
        JButton tag4 = new JButton("tag1");
        JButton tag5 = new JButton("tag1");

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
        JTextField text = new JTextField(40);
        JButton search = new JButton("SEARCH");
        panel.add(search, grb);
        grb.gridx = 1;
        grb.ipadx = 100;
        grb.ipady = 10;
        panel.add(text,grb);
        return panel;
    }
    private JPanel textPanel() {
        JPanel panel = new JPanel();
        JTextArea text = new JTextArea(40,70);
        panel.add(text);
        return panel;
    }


    public static void main(String[] args) {
        new RenderUI();
    }

}