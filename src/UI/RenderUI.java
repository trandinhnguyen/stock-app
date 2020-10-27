package UI;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RenderUI extends JFrame {

	public RenderUI() {
		setTitle("demo");
		setSize(900, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.add(new BenTrai());
		this.add(new BenPhai());
	}


}

