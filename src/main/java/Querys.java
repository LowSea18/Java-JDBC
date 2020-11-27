import java.sql.ResultSet;
import java.util.Scanner;

public class Querys {
    Scanner scanner = new Scanner(System.in);
    String que;
    public String add()
    {
        Footballer footballer = new Footballer();
        System.out.println("Please enter the name of the player : ");
        String name = scanner.nextLine();
        String uppName = name.toUpperCase();
        footballer.setName(uppName);
//////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Please enter the surname of the player : ");
        String surname = scanner.nextLine();
        String uppSurname = surname.toUpperCase();
        footballer.setSurname(uppSurname);
/////////////////////////////////////////////////////////////////////////////////////////
        int age;
        do {
        System.out.println("Please enter the age of the player : ");
        age = Integer.valueOf(scanner.nextLine());

        if(age<=0)
        {
            System.out.println("Age is incorrect");
        }
        }while (age<=0);
        footballer.setAge(age);
////////////////////////////////////////////////////////////////////////////////////////
        String position;
        boolean check = false;

        do {
            System.out.println("Please enter the position of the player : Goalkeeper, Defender, Midfilder, Striker");
            position = scanner.nextLine();
            String uppPosition = position.toUpperCase();



            if (uppPosition.equals("GOALKEEPER") || uppPosition.equals("DEFENDER") || uppPosition.equals("MIDFILDER") || uppPosition.equals("STRIKER"))
            {footballer.setPosition(uppPosition);
                check = true;}
            else {
                System.out.println("Position is incorrect ");
            }
        }while(!check);
////////////////////////////////////////////////////////////////////////////////////////
        que = "INSERT INTO footballers (name,surname,age,position)  VALUES ('"+footballer.getName()+"','"+footballer.getSurname()+"','"+footballer.getAge()+"','"+footballer.getPosition()+"')";

        return que;
    }

    public String showAll()
    {
        String all;
        all = "SELECT * FROM footballers";
        return all;
    }

    public String deleteplayer(){
        String que;
        int id;
        System.out.println("Give my id of a player to remove: ");
        id = scanner.nextInt();
        que = "delete from footballers where id = "+id;
        return que;
    }

    public String update(){
       String que = null;
       int id;
       int userChoise;
       do {
           System.out.println("Give my id of a player to Update");
           id = scanner.nextInt();
           System.out.println("1.Update name");
           System.out.println("2.Update surname");
           System.out.println("3.Update age");
           System.out.println("4.Update position");
           userChoise = scanner.nextInt();
       }while(userChoise<1 || userChoise>4);


        switch (userChoise){

            case 1:
                String name;
                System.out.println("Give me a new name");
                name = scanner.next();
                String Upname= name.toUpperCase();
                que="UPDATE footballers SET name = '"+Upname+"' WHERE id="+id;

                break;


            case 2:
                String surname;
                System.out.println("Give me a new surname");
                surname = scanner.next();
                String Upsurname= surname.toUpperCase();
                que="UPDATE footballers SET surname = '"+Upsurname+"' WHERE id="+id;
                break;

            case 3:
                int age;
                do {
                    System.out.println("Give me a new age");
                    age = scanner.nextInt();
                    if(age<=0)
                        System.out.println("Age is incorrect");
                }while (age<=0);
                que="UPDATE footballers set age = "+age+"WHERE id="+id;
                break;

            case 4:
                String position;
                String upPosition=null;
                boolean check = false;
                do {
                    System.out.println("Give me a new position : Goalkeeper, Defender, Midfilder, Striker");
                    position = scanner.next();
                    upPosition = position.toUpperCase();

                    if (upPosition.equals("GOALKEEPER") || upPosition.equals("DEFENDER") || upPosition.equals("MIDFILDER") || upPosition.equals("STRIKER"))
                        check = true;
                    else {
                        System.out.println("Position is incorrect ");
                    }
                }while(!check);
                que="UPDATE footballers set position = '"+upPosition+"' WHERE id="+id;
                break;


        }

        return que;


    }




}
