package GUI.Unemployed;

import Entities.Unemployed;
import Exceptions.UnemployedException;
import Repository.UnemployedRepository;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class DistDialog {
    public static JDialog getD(final Unemployed unemp) {
        final JDialog dial = new JDialog();
        dial.setBounds(200, 200, 400, 200);
        dial.setLayout(new GridBagLayout());

        JLabel jLabel = new JLabel("Возможно, анкета уже была зарегистрирована. Продолжить?");

        JButton button = new JButton("Да");
        JButton but = new JButton("Нет");
        JButton b = new JButton("Показать найденное");
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Unemployed> list = UnemployedRepository.getByParam("ФИО", unemp.getName());
                JFrame frame = FindUnempForm.getFrame(list);
                frame.setVisible(true);

            }
        };

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dial.dispose();
            }
        };

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UnemployedRepository.addFull(unemp);
                } catch (UnemployedException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(dial, "Регистрация прошла успешно");
                dial.dispose();
            }
        };
        button.addActionListener(act);
        but.addActionListener(ac);
        b.addActionListener(a);
        dial.add(jLabel, GUIService.setTopLabelConstraints());
        dial.add(button, GUIService.setLabelConstraints());
        dial.add(but, GUIService.setLabelConstraints());
        dial.add(b, GUIService.setLabelConstraints());

        return dial;
    }
}
