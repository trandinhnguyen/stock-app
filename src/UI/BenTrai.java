package UI;

import javax.swing.*;
import java.awt.*;

public class BenTrai extends JPanel {
    public BenTrai(){
        this.setBackground(Color.green);
        this.setSize(270,600);
        JButton b = new JButton("Ten");
        b.setBounds(30, 50, 200, 50);

        JButton c = new JButton("Ngay");
        c.setBounds(30, 150, 200, 50);

        JButton d = new JButton("Ma chung khoan");
        d.setBounds(30, 250, 200, 50);

        JButton e = new JButton("...");
        e.setBounds(30, 350, 200, 50);

        this.add(b);
        this.add(c);
        this.add(d);
        this.add(e);


    }
}
