import java.sql.*;

public class Select_Pre {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Sunny#123";

    public static void main(String[] args){
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          System.out.println(e.getMessage());
      }    

      try {
         Connection connection = DriverManager.getConnection(url,username,password);
         String query = String.format("SELECT name FROM Students WHERE id=?");
         PreparedStatement preparedStatement = connection.prepareStatement(query);

         preparedStatement.setInt(1, 1);
         ResultSet resultSet = preparedStatement.executeQuery();

         while(resultSet.next()){
            String name = resultSet.getString("name");
            System.out.println(name);
         }


      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
}
