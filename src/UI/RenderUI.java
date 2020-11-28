package UI;

import Model.DuLieuSinhCau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class RenderUI extends JFrame {

    private JPanel mainFrame;
    private JButton tag1, tag2, tag3, tag4, tag5, search;
    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;

    public RenderUI() {
        this.createJFrame();
        this.duLieuSinhCauArrayList = new ArrayList<DuLieuSinhCau>();
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

        tag1 = new JButton("Nhận đinh cổ phiếu");
        tag2 = new JButton("Nhận đinh doanh nghiệp");
        tag3 = new JButton("Tổng hợp");


        panel.add(tag1);
        panel.add(tag2);

        panel.add(tag3);

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
        String data = textsearch.getText();


        search = new JButton("SEARCH");


        panel.add(search, grb);
        grb.gridx = 1;
        grb.ipadx = 100;
        grb.ipady = 10;
        panel.add(textsearch, grb);
        return panel;
    }

    private JScrollPane textPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 15, 15));

//         JTextArea nhanDinh_1= new JTextArea(10,20);
//        panel.add(text1);


        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);


        return scroll;
    }

}