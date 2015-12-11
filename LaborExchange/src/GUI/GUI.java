package GUI;


import GUI.Company.CompaniesForm;
import GUI.Unemployed.UnemployedForm;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {


    public GUI() {
        super("Labor Exchange alpha");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 800, 700);
        JPanel panel = new JPanel(new BorderLayout());


        Font font = new Font("Verdana", Font.PLAIN, 16);

        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        tabbedPane.add("Безработные", UnemployedForm.getPanel());
        tabbedPane.add("Фирмы", CompaniesForm.getPanel());
        panel.add(tabbedPane);
        this.add(panel);


    }


}
