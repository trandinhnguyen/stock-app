package UI;

import javax.swing.*;
import java.awt.*;

public class LoadingUI extends JDialog {

    public LoadingUI() {
        this.init();
        this.setSize(200,100);
        this.setLocationRelativeTo(null);
        // this.setUndecorated(true);


        this.pack();
        // this.setModal(true);
        


    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JLabel message = new JLabel("Loading... please wait...");
        message.setForeground(Color.RED);
        this.add(message);
    }

}
