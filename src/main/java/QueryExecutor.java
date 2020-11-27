import java.sql.*;
import java.util.Scanner;

public class QueryExecutor {

    DbConnector dbConnector = new DbConnector();
    Scanner scanner = new Scanner(System.in);
    Connection connection;


    public void executeQuery(String query) {

          try{
           Connection connection = dbConnector.connect();
           Statement statement = connection.createStatement();
           statement.executeUpdate(query);
          }catch (SQLException e){

              throw new RuntimeException(e.getMessage());
          };
    }

    public ResultSet executeQuerySelect(String query) {

        try{
            Connection connection = dbConnector.connect();
            Statement statement = connection.createStatement();
           return statement.executeQuery(query);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }


    }



}



