import java.sql.*;

public class Update_Pre {

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

            String query = String.format("UPDATE students SET name=? WHERE id=?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "Sam");
            preparedStatement.setInt(2, 5);

            int rowaffected = preparedStatement.executeUpdate();
            if (rowaffected > 0) {
                System.out.println("UPDATE DATA SUCCFESSFULLY");
            } else {
                System.out.println("FAILED TO UPDATE");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
