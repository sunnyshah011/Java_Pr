import java.sql.SQLException;
import java.sql.*;

public class Delete {

    private static final String url = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Sunny#123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = String.format("DELETE FROM students WHERE id=%d",3);
            int rowaffected = statement.executeUpdate(query);
            if (rowaffected > 0) {
                System.out.println("ROW DELETED SUCCFESSFULLY");
            } else {
                System.out.println("FAILED TO DELETE");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
