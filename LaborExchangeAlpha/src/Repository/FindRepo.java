package Repository;

import Entities.Find;
import Entities.Unemployed;
import Exceptions.FindException;
import Utilities.DBService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class FindRepo {

    public static void addFind(Find f) throws FindException {
        check(f);
        String insert = "{CALL addFind(?,?)}";
        Connection con = DBService.connect();
        try {
            CallableStatement st = con.prepareCall(insert);
            st.setInt(1, f.getU_id());
            st.setString(2, f.getPos());
            st.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Find> getAllById(int id) {
        ArrayList<Find> list = new ArrayList<Find>();
        Connection con = DBService.connect();
        String insert = "SELECT f.id, p.name, f.u_id, u.fio FROM Find AS f, Pos AS p, Unemployed AS u" +
                " WHERE f.u_id = ? AND f.p_id = p.id AND u.id = f.u_id";
        try {
            CallableStatement st = con.prepareCall(insert);
            st.setInt(1, id);
            ResultSet set = st.executeQuery();
            while (set.next()) {
                list.add(new Find(
                        set.getInt(1),
                        set.getString(2),
                        set.getInt(3),
                        set.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String[][] getTable(ArrayList<Find> list) {
        String[][] data = new String[list.size()][4];
        int i = 0;
        for (Find find : list) {
            data[i][0] = String.valueOf(find.getId());
            data[i][1] = find.getPos();
            data[i][2] = String.valueOf(find.getU_id());
            data[i][3] = find.getName();
            i++;
        }
        return data;
    }

    private static void check(Find find) throws FindException {


        if (find.getPos() == null || "".equals(find.getPos())) {
            throw new FindException("Поле не заполнено");
        }


    }

    public static void intValidator(String age) throws FindException {
        final String PATTERN = "^[0-9][0-9]*$";
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(age);
        if (!matcher.matches()) {
            throw new FindException("Поле заполнено некорректно или не заполнено. Используйте существующие числовые значения");
        }

    }
}