package UI;

import Model.DuLieuSinhCau;
import Search.Search;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;


public class RenderUI extends JFrame {

    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;
    private JPanel panel;
    private ArrayList<DuLieuSinhCau> duLieuSinhCauSearch;
    private Search<DuLieuSinhCau> searchEngine;


    public RenderUI() {
        this.createJFrame();
        this.duLieuSinhCauArrayList = new ArrayList<DuLieuSinhCau>() ;
    }

    private void createJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Nhận đinh chứng khoán");
        JPanel mainFrame = this.createMainFrame();
        this.add(mainFrame);
    }


    private JPanel createMainFrame() {
        this.panel = new JPanel(new BorderLayout(10, 10));
        panel.add(this.buttonPanel(), BorderLayout.WEST);
        return panel;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        panel.setBackground(Color.LIGHT_GRAY);

        JButton tag1 = new JButton("Tổng hợp");
        JButton tag2 = new JButton("Nhận định mã cổ phiếu");
        JButton tag3 = new JButton("Nhận định công ti");


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

        JButton search = new JButton("SEARCH");

        DocumentListener realtime = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState(){
                String data = textsearch.getText();
                Search<DuLieuSinhCau> abc = new Search<DuLieuSinhCau>(duLieuSinhCauArrayList, data);
                System.out.println(abc.getResult().toString());

            }

        };

        textsearch.getDocument().addDocumentListener(realtime);

        search.addActionListener(e -> {
            String data = textsearch.getText();
            Search<DuLieuSinhCau> searchEngine = new Search<DuLieuSinhCau>(this.duLieuSinhCauArrayList, data);
            ArrayList<DuLieuSinhCau> dataSearch = searchEngine.getResult();
            System.out.println(dataSearch.toString());
//            for(int i = 0 ; i != 5 ; i++){
//                System.out.println(searchEngine.getCauTraLoi().get(i).getCauHienThi());
//            }
        });


        panel.add(search, grb);
        grb.gridx = 1;
        grb.ipadx = 100;
        grb.ipady = 10;
        panel.add(textsearch, grb);
        return panel;
    }

    private JScrollPane textPanelTongHop() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 15, 15));

        if(this.duLieuSinhCauArrayList != null)
            for(DuLieuSinhCau item: this.duLieuSinhCauArrayList) {
                JTextArea nhanDinh= new JTextArea(10,20);
                nhanDinh.setLineWrap(true);
                nhanDinh.setWrapStyleWord(true);
                nhanDinh.setFont(new Font("monospaced", Font.PLAIN, 14));
                nhanDinh.setEnabled(false);
                nhanDinh.setBackground(Color.GRAY);

                nhanDinh.append("- Nhận định mã cổ phiếu " + item.getId() +":");
                nhanDinh.append("\n");
                nhanDinh.append("- Thay đổi giá: " + item.getThayDoiGia());
                nhanDinh.append("\n");
                nhanDinh.append("- Nhận định công ty " + item.getId() + ":");
                nhanDinh.append("\n");
                nhanDinh.append("- Cơ cấu doanh nghiệp: " + item.getCoCauDoanhNghiep());
                panel.add(nhanDinh);

            }

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);


        return scroll;
    }

    public void setDuLieuSinhCauArrayList(ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList) {
        this.duLieuSinhCauArrayList = duLieuSinhCauArrayList;
        this.panel.add(this.textPanelTongHop());
        this.panel.add(this.searchPanel(), BorderLayout.NORTH);
        System.out.println(duLieuSinhCauArrayList.size());
    }

}