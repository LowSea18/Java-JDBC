import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnector {

    String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "Xxxxx11111#";
    Scanner scanner = new Scanner(System.in);






    public  Connection connect() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcURL,username,password);
            //System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;


    }


}
