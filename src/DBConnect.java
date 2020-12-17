import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

    private static Connection conn;
    private static String url = "jdbc:sqlite:G:/Code/Java/EC2Exam/EC2ExamDB/exam.db";

    public static Connection connect() throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace( );
        } catch (InvocationTargetException e) {
            e.printStackTrace( );
        }

        conn = DriverManager.getConnection(url);
        return conn;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}