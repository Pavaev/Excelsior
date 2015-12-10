package GUI;

import Entities.Unemployed;
import Exceptions.UnemployedException;
import Repository.UnemployedRepository;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel Shchepetov on 10.12.2015.
 */
public class UnemplProf {
    private final static Font TOPFONT = new Font("Arial", Font.BOLD, 22);

    public static JFrame getFrame(final Unemployed unemp) throws UnemployedException {
        final JFrame frame = new JFrame();
        frame.setBounds(20, 20, 400, 400);
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
        JButton button = new JButton("Удалить");
        ActionListener list = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnemployedRepository.deleteById(unemp.getId());
                JOptionPane.showMessageDialog(panel, "Профиль удален безвозратно...");
                frame.dispose();
                AllUnempForm.frame.setState(JFrame.NORMAL);
            }
        };
button.addActionListener(list);

        JButton but = new JButton("Подобрать вакансию");
        ActionListener lis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame newframe = VacFind.getPanel();
                newframe.setVisible(true);
            }
        };


        panel.add(button, GUIService.setTextFieldConstraints());

        frame.add(panel);

        return frame;
    }
}
