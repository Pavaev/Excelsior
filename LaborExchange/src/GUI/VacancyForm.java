package GUI;

import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel Shchepetov on 09.12.2015.
 */
public class VacancyForm {
    private final static Font TOPFONT = new Font("Arial", Font.BOLD, 22);


    public static JPanel getPanel() {


        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("Разместить вакансию");
        label.setFont(TOPFONT);
        panel.add(label, GUIService.setTopLabelConstraints());
        return null;
    }
}