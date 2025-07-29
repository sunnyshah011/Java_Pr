import java.sql.*;

public class PreparedStatemetn {
    
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
            // Statement statement = connection.createStatement();
            // String query = "select * from students";
            // ResultSet resultset = statement.executeQuery(query);

            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO students(name,age,marks) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "Tony");
            preparedStatement.setInt(2, 26);
            preparedStatement.setDouble(3, 86.3);

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("UPDATE DATA SUCCFESSFULLY");
            } else {
                System.out.println("FAILED TO UPDATE");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}