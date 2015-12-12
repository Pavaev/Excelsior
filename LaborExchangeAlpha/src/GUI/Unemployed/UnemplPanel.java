package GUI.Unemployed;

import Entities.Unemployed;
import Exceptions.UnemployedException;
import Repository.UnemployedRepository;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by Daniel Shchepetov on 06.12.2015.
 */
public class UnemplPanel {
    private final static Font TOPFONT = new Font("Arial", Font.BOLD, 22);

    public static JPanel getPanel() {


        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        final ButtonGroup bg = new ButtonGroup();
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("Анкета");
        label.setFont(TOPFONT);
        panel.add(label, GUIService.setTopLabelConstraints());


        JLabel name = new JLabel("ФИО: ");
        panel.add(name, GUIService.setLabelConstraints());
        final JTextField nameF = new JTextField(70);
        panel.add(nameF, GUIService.setTextFieldConstraints());


        JLabel age = new JLabel("Год рождения: ");
        panel.add(age, GUIService.setLabelConstraints());
        final JTextField ageF = new JTextField(2);
        panel.add(ageF, GUIService.setTextFieldConstraints());

        JLabel sex = new JLabel("Пол: ");
        panel.add(sex, GUIService.setLabelConstraints());

        final JRadioButton man = new JRadioButton("М", true);
        final JRadioButton woman = new JRadioButton("Ж", false);
        man.setBackground(Color.LIGHT_GRAY);
        woman.setBackground(Color.LIGHT_GRAY);


        bg.add(man);
        bg.add(woman);
        panel.add(man, GUIService.setRadioButtonConstraints());
        panel.add(woman, GUIService.setTextFieldConstraints());

        final JLabel sp = new JLabel("Семейное положение: ");
        panel.add(sp, GUIService.setLabelConstraints());

        final JComboBox spC = new JComboBox(GUIService.getSP());
        panel.add(spC, GUIService.setTextFieldConstraints());

        JLabel home = new JLabel("Жилищные условия: ");
        panel.add(home, GUIService.setLabelConstraints());
        final JComboBox homeF = new JComboBox(GUIService.getHome());
        panel.add(homeF, GUIService.setTextFieldConstraints());

        JLabel address = new JLabel("Адрес: ");
        panel.add(address, GUIService.setLabelConstraints());
        final JTextField addressF = new JTextField(50);
        panel.add(addressF, GUIService.setTextFieldConstraints());

        JLabel phone = new JLabel("Телефон: ");
        panel.add(phone, GUIService.setLabelConstraints());
        final JTextField phoneF = new JTextField(30);
        panel.add(phoneF, GUIService.setTextFieldConstraints());

        JLabel stud = new JLabel("Образование: ");
        panel.add(stud, GUIService.setLabelConstraints());
        final JComboBox studC = new JComboBox(GUIService.getStud());
        panel.add(studC, GUIService.setTextFieldConstraints());

        JLabel prof = new JLabel("Профессия: ");
        panel.add(prof, GUIService.setLabelConstraints());
        final JTextField profF = new JTextField(40);
        panel.add(profF, GUIService.setInsectTextFieldConstraints());

        JLabel lastWorkL = new JLabel("Предыдущее место работы ");
        panel.add(lastWorkL, GUIService.setTextFieldConstraints());
        JLabel lastWork = new JLabel("Фирма: ");
        panel.add(lastWork, GUIService.setLabelConstraints());
        final JTextField lastWorkF = new JTextField(40);
        panel.add(lastWorkF, GUIService.setTextFieldConstraints());

        JLabel lastPos = new JLabel("Должность: ");
        panel.add(lastPos, GUIService.setLabelConstraints());
        final JTextField lastPosF = new JTextField(30);
        panel.add(lastPosF, GUIService.setTextFieldConstraints());

        JLabel dismiss = new JLabel("Причина увольнения: ");
        panel.add(dismiss, GUIService.setLabelConstraints());
        final JTextField dismissF = new JTextField(50);
        panel.add(dismissF, GUIService.setInsectTextFieldConstraints());


        JButton addUnemployedButton = new JButton("Регистрация");
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameF.getText();
                String age = ageF.getText();
                String sp = (String) spC.getSelectedItem();
                String sex;
                String home = (String) homeF.getSelectedItem();
                String address = addressF.getText();
                String phone = phoneF.getText();
                String stud = (String) studC.getSelectedItem();
                String prof = profF.getText();
                String lastWork = lastWorkF.getText();
                String lastPos = lastPosF.getText();
                String dismiss = dismissF.getText();
                if (man.isSelected()) {
                    sex = man.getText();
                } else {
                    sex = woman.getText();
                }

                String message;
                message = "Регистрация прошла успешно";

                try {  //Validations and uniqueness
                    UnemployedRepository.intValidator(age);
                    Unemployed unemp = new Unemployed(name, Integer.parseInt(age), sex, sp, home, address, phone, stud, prof, lastWork, lastPos, dismiss);
                    if (UnemployedRepository.unempDist(unemp.getName(), unemp.getAge(), unemp.getProf())) {

                        UnemployedRepository.addFull(unemp);
                        JOptionPane.showMessageDialog(panel, message);
                        nameF.setText("");
                        ageF.setText("");
                        addressF.setText("");
                        phoneF.setText("");
                        profF.setText("");
                        lastWorkF.setText("");
                        lastPosF.setText("");
                        dismissF.setText("");
                    } else {
                        //if there is a match in DB, it prompts you for confirmation of adding
                        new DistDialog(unemp);


                    }

                } catch (UnemployedException ex) {
                    message = ex.getMessage();
                    JOptionPane.showMessageDialog(panel, message);
                    ex.printStackTrace();
                }


            }
        };
        addUnemployedButton.addActionListener(addListener);
        panel.add(addUnemployedButton, GUIService.setTextFieldConstraints());
        JButton button = new JButton("Показать всех безработных");
        ActionListener allListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AllUnempFrame();

            }
        };
        button.addActionListener(allListener);;
        panel.add(button, GUIService.setTextFieldConstraints());


        return panel;
    }


}
