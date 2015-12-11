package Repository;

import Entities.Find;
import Utilities.DBService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class FindRepo {

    public static void addFind(Find f) {
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


}
