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
    private JTextArea text1,text2,text3,text4,text5,text6,text7;
    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;
    private String out1,out2,out3,out4,out5,out6,out7;
    private JScrollPane scroll;

    public RenderUI() {
        this.duLieuSinhCauArrayList = new ArrayList<DuLieuSinhCau>();
        DuLieuSinhCau duLieu = new DuLieuSinhCau("FPT",new Date(), "1","2","3","b","a","v","k");
        DuLieuSinhCau duLieu1 = new DuLieuSinhCau("VI",new Date(), "abc","xz","a","b","a","v","k");
        DuLieuSinhCau duLieu2 = new DuLieuSinhCau("ABC",new Date(), "2","xqz","a","b","a","v","k");
        DuLieuSinhCau duLieu3 = new DuLieuSinhCau("APP",new Date(), "3","xz","a","b","a","v","k");
        DuLieuSinhCau duLieu4 = new DuLieuSinhCau("FQW",new Date(), "t","xqz","a","b","a","v","k");
        DuLieuSinhCau duLieu5 = new DuLieuSinhCau("VNM",new Date(), "q","xwz","a","b","a","v","k");
        DuLieuSinhCau duLieu6 = new DuLieuSinhCau("VIN",new Date(), "fc","xz","a","b","a","v","k");
        DuLieuSinhCau duLieu7 = new DuLieuSinhCau("FP", new Date(), "abc","xz","a","b","a","v","k");
        this.duLieuSinhCauArrayList.add(0,duLieu);
        this.duLieuSinhCauArrayList.add(1,duLieu1);
        this.duLieuSinhCauArrayList.add(2,duLieu2);
        this.duLieuSinhCauArrayList.add(3,duLieu3);
        this.duLieuSinhCauArrayList.add(4,duLieu4);
        this.duLieuSinhCauArrayList.add(5,duLieu5);
        this.duLieuSinhCauArrayList.add(6,duLieu6);
        this.duLieuSinhCauArrayList.add(7,duLieu7);
        createJFrame();

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
        String data = textsearch.getText();

        out1 = this.duLieuSinhCauArrayList.get(1).getId() + this.duLieuSinhCauArrayList.get(1).getNgay() +this.duLieuSinhCauArrayList.get(1).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(1).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(1).getKhoiLuong()+this.duLieuSinhCauArrayList.get(1).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(1).getId();
        out2 = this.duLieuSinhCauArrayList.get(2).getId() + this.duLieuSinhCauArrayList.get(2).getNgay() +this.duLieuSinhCauArrayList.get(2).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();
        out3 = this.duLieuSinhCauArrayList.get(3).getId() + this.duLieuSinhCauArrayList.get(3).getNgay() +this.duLieuSinhCauArrayList.get(3).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();
        out4 = this.duLieuSinhCauArrayList.get(4).getId() + this.duLieuSinhCauArrayList.get(4).getNgay() +this.duLieuSinhCauArrayList.get(4).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();
        out5 = this.duLieuSinhCauArrayList.get(5).getId() + this.duLieuSinhCauArrayList.get(5).getNgay() +this.duLieuSinhCauArrayList.get(5).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();
        out6 = this.duLieuSinhCauArrayList.get(6).getId() + this.duLieuSinhCauArrayList.get(6).getNgay() +this.duLieuSinhCauArrayList.get(6).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();
        out7 = this.duLieuSinhCauArrayList.get(7).getId() + this.duLieuSinhCauArrayList.get(7).getNgay() +this.duLieuSinhCauArrayList.get(7).getCoCauDoanhNghiep() +this.duLieuSinhCauArrayList.get(2).getKhaNangTangTruong()+this.duLieuSinhCauArrayList.get(2).getKhoiLuong()+this.duLieuSinhCauArrayList.get(2).getNhanDinhGia()+this.duLieuSinhCauArrayList.get(2).getId()+this.duLieuSinhCauArrayList.get(1).getId()+this.duLieuSinhCauArrayList.get(2).getId();

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

        text1 = new JTextArea(10,20);
        panel.add(text1);

        text2 = new JTextArea();
        panel.add(text2);

        text3 = new JTextArea();
        panel.add(text3);

        text4 = new JTextArea();
        panel.add(text4);

        text5 = new JTextArea();
        panel.add(text5);

        text6 = new JTextArea();
        panel.add(text6);

        text7 = new JTextArea();
        panel.add(text7);

        scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);


        return scroll;
    }

}