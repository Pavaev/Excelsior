package Repository;

import Entities.Find;
import Entities.Vacancy;
import Exceptions.VacancyException;
import Utilities.DBService;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daniel Shchepetov on 12.12.2015.
 */
public class VacancyRepo {


    public static ArrayList<Vacancy> getByFindId(String id) {
        ArrayList<Vacancy> list = new ArrayList<Vacancy>();
        Connection con = DBService.connect();
        String insert = "SELECT v.id, p.name, v.c_id, c.name,v.payment, v.cond, v.req, v.home FROM Vacancy AS v, Company AS c, Pos AS p " +
                "WHERE v.archive=0 AND v.p_id = p.id AND v.c_id = c.id AND p.id = (SELECT p_id FROM Find WHERE id=?)";
        try {
            CallableStatement st = con.prepareCall(insert);
            st.setInt(1, Integer.parseInt(id));
            ResultSet set = st.executeQuery();
            while (set.next()) {
                list.add(new Vacancy(
                        set.getInt(1),
                        set.getString(2),
                        set.getInt(3),
                        set.getString(4),
                        set.getInt(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static String[][] getTable(ArrayList<Vacancy> list) {
        String[][] data = new String[list.size()][8];
        int i = 0;
        for (Vacancy vac : list) {
            data[i][0] = String.valueOf(vac.getId());
            data[i][1] = vac.getPos();
            data[i][2] = String.valueOf(vac.getC_id());
            data[i][3] = vac.getCompany();
            data[i][4] = String.valueOf(vac.getPayment());
            data[i][5] = vac.getCond();
            data[i][6] = vac.getReq();
            data[i][7] = vac.getHome();
            i++;
        }
        return data;
    }

    public static void intValidator(String age) throws VacancyException {
        final String PATTERN = "^[0-9][0-9]*$";
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(age);
        if (!matcher.matches()) {
            throw new VacancyException("Поле заполнено некорректно или не заполнено. Используйте существующие числовые значения");
        }

    }

    public static void employ(int id, int uid) {
        String insert = "UPDATE Find \n" +
                "SET archive=? WHERE u_id = ?;\n" +
                "UPDATE Unemployed\n" +
                "SET archive = 1 WHERE id = ?;\n" +
                "UPDATE Vacancy \n" +
                "SET archive = 1 WHERE id = ?;";


        PreparedStatement p;
        try {
            p = DBService.connect().prepareStatement(insert);

            p.setInt(1, id);
            p.setInt(2, uid);
            p.setInt(3, uid);
            p.setInt(4, id);
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
