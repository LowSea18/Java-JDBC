import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello word");

        DbConnector dbConnector = new DbConnector();
        QueryExecutor queryExecutor = new QueryExecutor();
        Querys querys = new Querys();



        Scanner scanner = new Scanner(System.in);

        boolean shouldIEnd = false;

        do {

            System.out.println("1.Add footballer into the team");
            System.out.println("2.Show my team");
            System.out.println("3.Remove a player");
            System.out.println("4.Update a player");
            System.out.println("5.End");
            System.out.println();

            int userChoice = scanner.nextInt();
            switch (userChoice) {

                case 1:
                    System.out.println("Add footballer into the team");
                    queryExecutor.executeQuery(querys.add());
                    System.out.println();
                    break;

                case 2:
                    try{
                        System.out.println("Show team");
                        System.out.println();
                        ResultSet resultSet = queryExecutor.executeQuerySelect(querys.showAll());

                        while(resultSet.next()) {
                            //resultSet.next();
                            int userid = resultSet.getInt("id");
                            String username = resultSet.getString("name");
                            String usersurname = resultSet.getString("surname");
                            int userage = resultSet.getInt("age");
                            String userposition = resultSet.getString("position");
                            System.out.println("Id: " +userid);
                            System.out.println("Name: "+username);
                            System.out.println("Surname: " +usersurname);
                            System.out.println("Age: "+userage);
                            System.out.println("Position: "+userposition);
                            System.out.println();
                            System.out.println();
                            System.out.println();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;


               case 3:
                    System.out.println("Remove a player: ");
                    queryExecutor.executeQuery(querys.deleteplayer());
                    break;

               case 4:
                   System.out.println("Update a player: ");
                   queryExecutor.executeQuery(querys.update());
                   break;
               case 5:
                    shouldIEnd=true;
            }
        }while(!shouldIEnd);








    }
}
