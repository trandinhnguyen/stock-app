package UI;


import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

    public class BenPhai extends JPanel {

        public BenPhai(){
            JTextArea text = new JTextArea();
            JTextField search = new JTextField();
            this.setBackground(Color.yellow);
            this.setSize(500,600);
            text.setBounds(300,100,700,300);
            text.setBackground(Color.WHITE);

            search.setBounds(500,35,300,30);

            JButton buttonimage = new JButton("SEARCH");
            buttonimage.setBounds(400,35,100,30);

            this.add(text);
            this.add(search);
            this.add(buttonimage);
        }

    };


