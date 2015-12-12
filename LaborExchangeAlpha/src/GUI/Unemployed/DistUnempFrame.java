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
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class DistUnempFrame {
    private static JFrame frame;
    private Unemployed unemp;

    public DistUnempFrame( Unemployed unemp) {


        frame = new JFrame();
        frame.setBounds(30, 30, 1200, 700);


        String[] labels = {"ID", "Имя", "Год рождения", "Пол", "Адрес", "Телефон", "Профессия", "Образование", "В архиве"};

        String[][] rows = UnemployedRepository.getDistTable(UnemployedRepository.getConflicts(unemp.getName(), unemp.getAge(), unemp.getProf()));
        final JTable table = new JTable(rows, labels);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);

        frame.setVisible(true);
    }


    public Unemployed getUnemp() {
        return unemp;
    }

    public void setUnemp(Unemployed unemp) {
        this.unemp = unemp;
    }
}