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
public class FindUnempForm {
    public static JFrame frame;

    public static JFrame getFrame(ArrayList<Unemployed> list) {


        frame = new JFrame();
        frame.setBounds(30, 30, 1200, 700);


        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        JButton button;

        String[] labels = {"ID", "Имя", "Год рождения", "Пол", "Адрес", "Телефон", "Профессия", "Образование"};

        String[][] rows = UnemployedRepository.getTable(list);
        final JTable table = new JTable(rows, labels);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.NORTH);

        JLabel label = new JLabel("Введите ID:");
        panel.add(label, GUIService.setTopLabelConstraints());


        final JTextField field = new JTextField();
        panel.add(field, GUIService.setTextFieldConstraints());

        button = new JButton("Показать полный профиль");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = field.getText();
                try {
                    UnemployedRepository.ageValidator(id);
                    Unemployed unemp = UnemployedRepository.getById(Integer.parseInt(id));
                    if (unemp != null) {
                        JFrame f = UnemplProf.getFrame(unemp);
                        f.setVisible(true);
                        field.setText("");
                    } else {
                        JOptionPane.showMessageDialog(panel, "Ничего не найдено");
                    }
                } catch (UnemployedException ex) {
                    JOptionPane.showMessageDialog(panel, "Ничего не найдено");
                    ex.printStackTrace();
                }


            }


        };
        button.addActionListener(listener);
        panel.add(button, GUIService.setLabelConstraints());
        frame.add(panel, BorderLayout.CENTER);
        return frame;
    }
}