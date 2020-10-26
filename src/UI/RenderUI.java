package UI;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RenderUI extends JFrame {
	JPanel tags = new JPanel();
    JTextArea text = new JTextArea();
    JTextField search = new JTextField();

	public RenderUI() {
		setTitle("demo");
		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		benTrai();
		benPhai();
	}
	public void benTrai(){
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.green);
		pn1.setSize(270,600);
		JButton b = new JButton("Ten");
		b.setBounds(30, 50, 200, 50);
		
		JButton c = new JButton("Ngay");
		c.setBounds(30, 150, 200, 50);
		
		JButton d = new JButton("Ma chung khoan");
		d.setBounds(30, 250, 200, 50);
		
		JButton e = new JButton("...");
		e.setBounds(30, 350, 200, 50);
		
		pn1.add(b);
		pn1.add(c);
		pn1.add(d);
		pn1.add(e);
		
		add(pn1);
		
	}
	public void benPhai() {
		 add(text);
         text.setBounds(280,100,700,1000);
         text.setBackground(Color.WHITE);

         add(search);
         search.setBounds(500,35,300,30);


         JButton buttonimage = new JButton("SEARCH");
         add(buttonimage);
         buttonimage.setBounds(400,35,100,30);
	}
	public static void main(String[] args) {
	new RenderUI();
}
	
	}

