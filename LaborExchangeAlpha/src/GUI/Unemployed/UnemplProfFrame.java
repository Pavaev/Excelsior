package GUI.Unemployed;

import Entities.Find;
import Entities.Unemployed;
import Exceptions.FindException;
import GUI.Find.FindUnempFrame;
import Repository.FindRepo;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel Shchepetov on 10.12.2015.
 */
public class UnemplProfFrame {

    private static JFrame frame;
    private final static Font TOPFONT = new Font("Arial", Font.BOLD, 22);

    public UnemplProfFrame(final Unemployed unemp) {
        frame = new JFrame();
        frame.setBounds(20, 20, 500, 500);
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("Профиль");
        label.setFont(TOPFONT);

        panel.add(label, GUIService.setTopLabelConstraints());
        final JLabel id = new JLabel("ID: " + unemp.getId());
        final JLabel name = new JLabel("Имя: " + unemp.getName());
        final JLabel age = new JLabel("Возраст: " + unemp.getAge());
        final JLabel sex = new JLabel("Пол: " + unemp.getSex());
        final JLabel sp = new JLabel("Семейное положение: " + unemp.getSp());
        final JLabel prof = new JLabel("Профессия: " + unemp.getProf());
        final JLabel stud = new JLabel("Образование: " + unemp.getStud());
        final JLabel address = new JLabel("Адрес: " + unemp.getAddress());
        final JLabel phone = new JLabel("Телефон: " + unemp.getPhone());
        final JLabel lastwork = new JLabel("Предыдущее место работы: " + unemp.getLastWork());
        final JLabel lastpos = new JLabel("Должность: " + unemp.getLastPos());
        final JLabel dismiss = new JLabel("Причина увольнения: " + unemp.getDismiss());

        panel.add(id, GUIService.setTextFieldConstraints());
        panel.add(name, GUIService.setTextFieldConstraints());
        panel.add(age, GUIService.setTextFieldConstraints());
        panel.add(sex, GUIService.setTextFieldConstraints());
        panel.add(sp, GUIService.setTextFieldConstraints());
        panel.add(prof, GUIService.setTextFieldConstraints());
        panel.add(stud, GUIService.setTextFieldConstraints());
        panel.add(address, GUIService.setTextFieldConstraints());
        panel.add(phone, GUIService.setTextFieldConstraints());
        panel.add(lastwork, GUIService.setTextFieldConstraints());
        panel.add(lastpos, GUIService.setTextFieldConstraints());
        panel.add(dismiss, GUIService.setTextFieldConstraints());
        JButton button = new JButton("Удалить профиль");
        ActionListener list = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dial = ProfDelDialog.getD(unemp.getId());
                dial.setVisible(true);

            }

        };
        button.addActionListener(list);

        // KMP!!! I don't want to continue...

        JLabel posL = new JLabel("Введите желаемую должность: ");
        panel.add(posL, GUIService.setLabelConstraints());

        final JTextField posF = new JTextField();
        panel.add(posF, GUIService.setTextFieldConstraints());
        final JButton but = new JButton("Разместить заявку");

        ActionListener lis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pos = posF.getText();
                try {
                    FindRepo.addFind(new Find(unemp.getId(), pos));
                    JOptionPane.showMessageDialog(panel, "Успешно!");
                } catch (FindException e1) {

                    JOptionPane.showMessageDialog(panel, e1.getMessage());

                    e1.printStackTrace();
                }

                posF.setText("");
            }
        };

        but.addActionListener(lis);

        final JButton b = new JButton("Показать заявки");
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindUnempFrame(unemp);
            }
        };
        b.addActionListener(l);

        JButton bu = new JButton("Создать объявление");
        ActionListener li = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        panel.add(but, GUIService.setTextFieldConstraints());
        panel.add(b, GUIService.setTextFieldConstraints());
        panel.add(button, GUIService.setTextFieldConstraints());
        panel.add(bu, GUIService.setTextFieldConstraints());


        frame.add(panel);

        frame.setVisible(true);
    }


    public static JFrame getFrame() {
        return frame;
    }
}
