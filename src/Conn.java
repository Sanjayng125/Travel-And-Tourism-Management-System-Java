import java.sql.DriverManager;

public class Connection {

    Connection c;
    Connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
