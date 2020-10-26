package UI;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

    public class benPhai {
        JPanel tags = new JPanel();
        JTextArea text = new JTextArea();
        JTextField search = new JTextField();


        public benPhai(){
            JFrame frame = new JFrame();
            frame.setTitle("Chuong trinh loc cau");
            frame.setSize(900,600);
            frame.setLayout(null);
            frame.setVisible(true);
//ben trai
//        frame.add(tags);
//        tags.setBounds(0,100,300,1000);
//        tags.setBackground(Color.GRAY);

            frame.add(text);
            text.setBounds(300,100,700,1000);
            text.setBackground(Color.WHITE);

            frame.add(search);
            search.setBounds(500,35,300,30);


            JButton buttonimage = new JButton("SEARCH");
            frame.add(buttonimage);
            buttonimage.setBounds(400,35,100,30);



            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//ben trai
//        JButton hottag1 = new JButton("hottag1");
//        hottag1.setForeground(Color.RED);
//        hottag1.setBounds(10,30,100,50);
//        tags.add(hottag1);
//
//        JButton hottag2 = new JButton("hottag2");
//        hottag2.setForeground(Color.RED);
//        hottag2.setBounds(190,30,100,50);
//        tags.add(hottag2);
//
//        JButton hottag3 = new JButton("hottag3");
//        hottag3.setForeground(Color.RED);
//        hottag3.setBounds(10,100,100,50);
//        tags.add(hottag3);
//
//        JButton tag1 = new JButton("tag1");
//        tag1.setBounds(190,100,100,50);
//        tags.add(tag1);
//
//        JButton tag2 = new JButton("tag2");
//        tag2.setBounds(10,170,100,50);
//        tags.add(tag2);
//
//        JButton tag3 = new JButton("tag3");
//        tag3.setBounds(190,170,100,50);
//        tags.add(tag3);

        }

        public static void main(String[] args){

            new benPhai();
        }
    };


