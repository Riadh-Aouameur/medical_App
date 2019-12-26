package Medical;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riadh
 */
public class Db {
    private Connection con ;
    private Statement st ;
    private ResultSet rs ;
    public Db (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/","root","1234");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Errer : " + ex);

        }




    }
    public void getData(){
        try {
            String query = "";
            rs = st.executeQuery(query);
            System.out.println("records from database");
            while(rs.next()){
                String test = rs.getString("");

                System.out.println();


            }
        }catch(Exception ex){
            System.out.println(ex);
        }




    }


    public void Show(){
        try {


            String query = "show tables from medical";
            System.out.println("records from databases");

            if (st.execute(query)) {
                rs = st.getResultSet();
            }
            while(rs.next()){
                String database =rs.getString("Tables_in_medical");
                System.out.println(database);




            }

        }catch(Exception ex){
            System.out.println(ex);
        }




    }

    public void setData(){
        try {
            String query = "";
            st.addBatch(query);
            st.executeBatch();
            System.out.println("Insert");

        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

