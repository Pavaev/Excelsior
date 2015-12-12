package GUI.Unemployed;

import Repository.UnemployedRepository;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class ProfDelDialog {

    public static JDialog getD(final int id) {
        final JDialog dial = new JDialog();
        dial.setBounds(200, 200, 350, 200);
        dial.setLayout(new GridBagLayout());

        JLabel jLabel = new JLabel("Вы действительно хотите удалить этот профиль?");
        JLabel lab = new JLabel("Все его заявки будут удалены");
        JLabel l = new JLabel("Отменить изменения будет невозможно");
        JButton button = new JButton("Да");
        JButton but = new JButton("Нет");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnemployedRepository.deleteById(id);
                UnemplProfFrame.getFrame().dispose();

                dial.dispose();

                JOptionPane.showMessageDialog(dial, "Профиль удален безвозратно...");
                AllUnempFrame.getFrame().dispose();
                new AllUnempFrame();


            }
        };
        button.addActionListener(listener);

        ActionListener lis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dial.dispose();
            }
        };

        but.addActionListener(lis);
        dial.add(jLabel, GUIService.setTopLabelConstraints());
        dial.add(lab, GUIService.setTopLabelConstraints());
        dial.add(l, GUIService.setTopLabelConstraints());
        dial.add(button, GUIService.setLabelConstraints());
        dial.add(but, GUIService.setLabelConstraints());
        return dial;
    }
}
