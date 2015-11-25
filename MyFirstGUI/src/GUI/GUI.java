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

        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        this.add(tabbedPane);

        final JPanel productContent = ProductAdd.getPanel();
        JPanel listOfProducts = ListOfProducts.getProductPanel();
        tabbedPane.addTab("Products", productContent);
        tabbedPane.addTab("List Of Products", listOfProducts);


    }


}
