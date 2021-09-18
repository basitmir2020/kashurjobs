package catalog;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.userModel;
import persistence.dbContext;

public class dataBase {

    public static boolean Excute(userModel um, String val) {
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(val));
            um.getResultset().next();

            return true;
        } catch (SQLException e) {
            um.setMessage(e.getMessage());
            return false;
        }finally {
            dbContext.Close(dbContext.connect());
        }
    }

    public static boolean saveDb(userModel um, String val) {
        try {
            PreparedStatement pstat = dbContext.connect().prepareStatement(val);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally {
            dbContext.Close(dbContext.connect());
        }
    }

    public static boolean CheckUser(userModel um, String val) {
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(val));
            return !um.getResultset().next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally {
            dbContext.Close(dbContext.connect());
        }
    }

    public static boolean id(userModel um, String val) {
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(val));
            while (um.getResultset().next()) {
                um.setCompanyId(um.getResultset().getInt("id"));
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            dbContext.Close(dbContext.connect());
        }
    }

}
