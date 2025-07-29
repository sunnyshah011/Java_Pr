import java.sql.*;
import java.util.Scanner;

public class App {

    public static final String url = "jdbc:mysql://localhost:3306/jdbc";
    public static final String username = "root";
    public static final String password = "Sunny#123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);

            String createTableQuery = "CREATE TABLE IF NOT EXISTS newtable ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "age INT, "
                    + "marks DOUBLE"
                    + ")";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table 'students' checked/created.");

            while (true) {
                System.out.print("ENTER NAME = ");
                String name = scanner.next();
                System.out.print("enter age = ");
                int age = scanner.nextInt();
                System.out.print("enter marks = ");
                double marks = scanner.nextDouble();

                String query = String.format("INSERT INTO newtable(name,age,marks) VALUES('%s',%o,%f)", name,age,marks);
                statement.addBatch(query);
                System.out.print("enter more data: Y/N : ");
                String data = scanner.next();

                if(data.toUpperCase().equals("N")){
                    break;
                }

                scanner.close();
            }

            int [] arr = statement.executeBatch();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}