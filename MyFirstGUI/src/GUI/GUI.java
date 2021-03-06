package GUI;


import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        super("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setBounds(150, 150, 500, 300);

        Font font = new Font("Verdana", Font.PLAIN, 16);
        JPanel panel = new JPanel(new BorderLayout());

        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        panel.add(tabbedPane);
        this.add(panel);

        final JPanel productContent = ProductAdd.getPanel();

        tabbedPane.addTab("Products", productContent);


    }


}
