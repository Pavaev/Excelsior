package GUI.Company;

import GUI.GUI;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Shchepetov on 06.12.2015.
 */
public class CompaniesForm {
    final static Font TOPFONT = new Font("Arial", Font.BOLD, 22);

    public static JPanel getPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Добавить новую фирму");
        label.setFont(TOPFONT);
        panel.add(label, GUIService.setTopLabelConstraints());

        JLabel name = new JLabel("Название: ");
        panel.add(name, GUIService.setLabelConstraints());
        final JTextField nameF = new JTextField(40);
        panel.add(nameF, GUIService.setTextFieldConstraints());

        JLabel adres = new JLabel("Адрес: ");
        panel.add(adres, GUIService.setLabelConstraints());
        final JTextField adresF = new JTextField(40);
        panel.add(adresF, GUIService.setTextFieldConstraints());

        JLabel phone = new JLabel("Телефон: ");
        panel.add(phone, GUIService.setLabelConstraints());
        final JTextField phoneF = new JTextField(30);
        panel.add(phoneF, GUIService.setTextFieldConstraints());

        return panel;
    }
}
