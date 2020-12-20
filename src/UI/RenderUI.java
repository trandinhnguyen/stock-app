package UI;

import Model.DuLieuSinhCau;
import Search.Search;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;


public class RenderUI extends JFrame {

    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;
    private JPanel panel;
    private JScrollPane scrollPanel;
    private ArrayList<DuLieuSinhCau> solution;
    private String VNINDEX;



    public RenderUI() {
        this.createJFrame();
        this.duLieuSinhCauArrayList = new ArrayList<>();
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
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panel.setBackground(Color.LIGHT_GRAY);

        JButton VNINDEXButton = new JButton("Nhân định VNINDEX");
        VNINDEXButton.addActionListener(e -> this.updatePanel());

        JButton tongHopButton = new JButton("Tổng hợp");
        tongHopButton.addActionListener(e -> this.updatePanel(this.duLieuSinhCauArrayList, "tongHop"));

        JButton maCoPhieuButton = new JButton("Nhận định mã cổ phiếu");
        maCoPhieuButton.addActionListener(e -> this.updatePanel(this.duLieuSinhCauArrayList, "maCoPhieu"));
        JButton congTiButton = new JButton("Nhận định công ty");
        congTiButton.addActionListener(e -> this.updatePanel(this.duLieuSinhCauArrayList, "congTy"));


        panel.add(VNINDEXButton);
        panel.add(tongHopButton);
        panel.add(maCoPhieuButton);
        panel.add(congTiButton);


        return panel;
    }

    private JPanel searchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 100, 15, 30));
        GridBagConstraints grb = new GridBagConstraints();
        grb.gridx = 0;
        grb.gridy = 0;
        grb.ipady = 4;
        JTextField textSearch = new JTextField(40);

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

            protected void updateFieldState() {
                String data = textSearch.getText();
                Search<DuLieuSinhCau> key = new Search<>(duLieuSinhCauArrayList);
                //
                updatePanel(key.getResult(data), "tongHop");
            }

        };

        textSearch.getDocument().addDocumentListener(realtime);



        panel.add(search, grb);
        grb.gridx = 1;
        grb.ipadx = 100;
        grb.ipady = 10;
        panel.add(textSearch, grb);
        return panel;
    }

    private JScrollPane renderTongHop() {
        JPanel panel = new JPanel(new GridLayout(30, 1, 15, 15));

        for (DuLieuSinhCau item : this.solution) {
            JTextArea nhanDinh = new JTextArea(10, 20);
            nhanDinh.setLineWrap(true);
            nhanDinh.setWrapStyleWord(true);
            nhanDinh.setFont(new Font("monospaced", Font.PLAIN, 14));
            nhanDinh.setEnabled(false);
            nhanDinh.setBackground(Color.GRAY);
            nhanDinh.append("- Nhận định mã cổ phiếu " + item.getId() + ":");
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

        this.scrollPanel = scroll;
        return scroll;
    }

    private JScrollPane renderMaCoPhieu() {
        JPanel panel = new JPanel(new GridLayout(30, 1, 15, 15));

        for (DuLieuSinhCau item : this.solution) {
            JTextArea nhanDinh = new JTextArea(10, 20);
            nhanDinh.setLineWrap(true);
            nhanDinh.setWrapStyleWord(true);
            nhanDinh.setFont(new Font("monospaced", Font.PLAIN, 14));
            nhanDinh.setEnabled(false);
            nhanDinh.setBackground(Color.GRAY);
            nhanDinh.append("- Nhận định mã cổ phiếu " + item.getId() + ":");
            nhanDinh.append("\n");
            nhanDinh.append("- " + item.getThayDoiGia());
            nhanDinh.append("\n");

            panel.add(nhanDinh);

        }

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);

        this.scrollPanel = scroll;
        return scroll;
    }

    private JScrollPane renderCongTy() {
        JPanel panel = new JPanel(new GridLayout(30, 1, 15, 15));

        for (DuLieuSinhCau item : this.solution) {
            JTextArea nhanDinh = new JTextArea(10, 20);
            nhanDinh.setLineWrap(true);
            nhanDinh.setWrapStyleWord(true);
            nhanDinh.setFont(new Font("monospaced", Font.PLAIN, 14));
            nhanDinh.setEnabled(false);
            nhanDinh.setBackground(Color.GRAY);
            nhanDinh.append("- Nhận định công ty " + item.getId() + ":");
            nhanDinh.append("\n");
            nhanDinh.append("- " + item.getCoCauDoanhNghiep());
            nhanDinh.append("\n");

            panel.add(nhanDinh);

        }

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);

        this.scrollPanel = scroll;
        return scroll;
    }

    private JScrollPane renderVNINDEX() {
        JPanel panel = new JPanel(new GridLayout(30, 1, 15, 15));


        JTextArea nhanDinh = new JTextArea(10, 20);
        nhanDinh.setLineWrap(true);
        nhanDinh.setWrapStyleWord(true);
        nhanDinh.setFont(new Font("monospaced", Font.PLAIN, 14));
        nhanDinh.setEnabled(false);
        nhanDinh.setBackground(Color.GRAY);
        nhanDinh.append("- Nhận định VNINDEX :");
        nhanDinh.append("\n");
        nhanDinh.append(this.VNINDEX);
        panel.add(nhanDinh);



        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(panel);

        this.scrollPanel = scroll;
        return scroll;
    }

    private void updatePanel(ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList, String field) {
        this.solution = duLieuSinhCauArrayList;
        this.panel.remove(this.scrollPanel);

        this.panel.revalidate();
        this.panel.repaint();

        switch (field) {
            case "tongHop" -> this.panel.add(this.renderTongHop());
            case "maCoPhieu" -> this.panel.add(this.renderMaCoPhieu());
            case "congTy" -> this.panel.add(this.renderCongTy());
        }

    }



    private void updatePanel() {

        // remove panel
        this.panel.remove(this.scrollPanel);
        this.panel.revalidate();
        this.panel.repaint();

        this.panel.add(this.renderVNINDEX());
    }


    public void setDuLieuSinhCauArrayList(ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList, String VNINDEX) {
        this.duLieuSinhCauArrayList = duLieuSinhCauArrayList;
        this.VNINDEX = VNINDEX;


        this.solution = duLieuSinhCauArrayList;


        this.panel.add(this.renderTongHop());
        this.panel.add(this.searchPanel(), BorderLayout.NORTH);

        System.out.println(duLieuSinhCauArrayList.size());
    }

}