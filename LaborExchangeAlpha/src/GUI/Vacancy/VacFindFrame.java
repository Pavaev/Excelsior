package GUI.Vacancy;

import Entities.Vacancy;
import Exceptions.FindException;
import Exceptions.VacancyException;
import GUI.Find.FindUnempFrame;
import GUI.Unemployed.AllUnempFrame;
import GUI.Unemployed.UnemplProfFrame;
import Repository.VacancyRepo;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Daniel Shchepetov on 12.12.2015.
 */
public class VacFindFrame {
    private static JFrame frame;
    public VacFindFrame(ArrayList<Vacancy> list, int uid){



            frame = new JFrame();
            frame.setBounds(30, 30, 1200, 700);

            frame.setLayout(new BorderLayout());
            final JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(Color.LIGHT_GRAY);

            String[] labels = {"ID", "Должность", "ID компании", "Название компании", "Оплата", "Условия", "Требования", "Жил.условия"};

            String[][] rows = VacancyRepo.getTable(list);

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

            JButton  button = new JButton("Трудоустроить");
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = field.getText();
                    //Validation
                    try {
                        VacancyRepo.intValidator(id);
                        VacancyRepo.employ(Integer.parseInt(id), uid);
                        JOptionPane.showMessageDialog(panel, "Трудоустроен! Анкета клиента помещена в архив");
                        frame.dispose();
                        FindUnempFrame.getFrame().dispose();
                        UnemplProfFrame.getFrame().dispose();
                        AllUnempFrame.getFrame().dispose();
                        new AllUnempFrame();

                    } catch (VacancyException e1) {
                        JOptionPane.showMessageDialog(panel, e1.getMessage());
                        e1.printStackTrace();
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


