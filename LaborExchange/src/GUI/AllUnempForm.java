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
 * Created by Daniel Shchepetov on 09.12.2015.
 */
public class AllUnempForm extends JFrame {
    static final JFrame frame = new JFrame();
    public static JFrame getFrame() {

        frame.setBounds(30, 30, 1200, 700);


        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);
         JButton button;

        String[] labels = {"ID", "Имя", "Возраст", "Пол", "Адрес", "Телефон", "Профессия", "Образование"};
        String[][] rows = UnemployedRepository.getTable();
        final JTable table = new JTable(rows, labels);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);

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
                        JFrame frame = UnemplProf.getFrame(unemp);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Ничего не найдено");
                    }
                } catch (UnemployedException ex) {
                    JOptionPane.showMessageDialog(panel, "Ничего не найдено");
                    ex.printStackTrace();
                }
                frame.setState(JFrame.ICONIFIED);
            }


        };
        button.addActionListener(listener);
        panel.add(button, GUIService.setLabelConstraints());
        JButton refr = UnemployedForm.getButton();
        refr.setText("Обновить");
        panel.add(refr, GUIService.setLabelConstraints());
        frame.add(panel, BorderLayout.CENTER);
        return frame;
    }
}
