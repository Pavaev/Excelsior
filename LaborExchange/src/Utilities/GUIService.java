package Utilities;


import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GUIService {
    public static GridBagConstraints setLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.weightx = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;

        return c;
    }

    public static GridBagConstraints setTextFieldConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }

    public static GridBagConstraints setTopLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }

    public static GridBagConstraints setRadioButtonConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE;
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        return c;
    }

    public static String[] getSP() {
        Connection con = DBService.connect();
        ArrayList<String> list = new ArrayList();
        try {
            PreparedStatement st = con.prepareStatement("SELECT sp FROM Sp");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                list.add(res.getString("sp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] items = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            items[i] = list.get(i);
        }
        return items;
    }

    public static String[] getHome() {
        Connection con = DBService.connect();
        ArrayList<String> list = new ArrayList();
        try {
            PreparedStatement st = con.prepareStatement("SELECT home FROM Home");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                list.add(res.getString("home"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] items = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            items[i] = list.get(i);
        }
        return items;
    }

    public static String[] getStud() {
        Connection con = DBService.connect();
        ArrayList<String> list = new ArrayList();
        try {
            PreparedStatement st = con.prepareStatement("SELECT stud FROM Stud");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                list.add(res.getString("stud"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] items = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            items[i] = list.get(i);
        }
        return items;

    }

    public static GridBagConstraints setInsectTextFieldConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 30, 2);
        c.anchor = GridBagConstraints.BASELINE;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }

}
