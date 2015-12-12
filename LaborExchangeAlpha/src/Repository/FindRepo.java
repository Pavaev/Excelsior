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
        String insert = "SELECT id, pos FROM Find WHERE archive = 0 AND u_id = ?";
        try {
            CallableStatement st = con.prepareCall(insert);
            st.setInt(1,id);
            ResultSet set = st.executeQuery();
            while (set.next()) {
                list.add(new Find(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String[][] getTable(ArrayList<Find> list) {
        String[][] data = new String[list.size()][2];
        int i = 0;
        for (Find find : list) {
            data[i][0] = String.valueOf(find.getId());
            data[i][1] = find.getName();
            i++;
        }
        return data;
    }

    private static void check(Find find) throws FindException {


        if (find.getName() == null || "".equals(find.getName())) {
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