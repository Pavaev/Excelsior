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
 * Created by Daniel Shchepetov on 09.12.2015.
 */
public class AllUnempFrame extends JFrame {

    private static JFrame frame;

    public AllUnempFrame() {
        frame = new JFrame();
        frame.setBounds(30, 30, 1200, 700);

        frame.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        String[] labels = {"ID", "Имя", "Год рождения", "Пол", "Адрес", "Телефон", "Профессия", "Образование"};
        ArrayList<Unemployed> list = UnemployedRepository.getAll();
        String[][] rows = UnemployedRepository.getTable(list);

        JTable table = new JTable(rows, labels);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.NORTH);

        JLabel label = new JLabel("Введите ID:");
        panel.add(label, GUIService.setTopLabelConstraints());


        final JTextField field = new JTextField();
        panel.add(field, GUIService.setTextFieldConstraints());

        JButton  button = new JButton("Показать полный профиль");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = field.getText();
                try { //Validation
                    UnemployedRepository.intValidator(id);
                    Unemployed unemp = UnemployedRepository.getById(Integer.parseInt(id));
                    if (unemp != null) {
                        new UnemplProfFrame(unemp);

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
        frame.setVisible(true);
    }


    public static JFrame getFrame() {
        return frame;
    }
}