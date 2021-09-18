package persistence;
import config.configuration;
import java.sql.*;
public class dbContext {
    private static Connection con = null;
    private static String status; 

    public static String getStatus() {
        return status;
    }
    
    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(""+configuration.DBHOST+""+configuration.DBNAME+"",
                    ""+configuration.DBUSER+"",""+configuration.DBPASS+"");
           dbContext.status="Connected";
        }catch(SQLException | ClassNotFoundException e){
             dbContext.status = e.getMessage();
        }
        return dbContext.con;
    }
    
     public static void Close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            dbContext.status = e.getMessage();
        }
    }
    
}
