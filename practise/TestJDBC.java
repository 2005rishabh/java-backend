import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Added missing import
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
  private static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
  private static String username = "rishabh";
  private static String password = "password123";
  
  public static void main(String[] args) {
    try {
        Class.
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Driver not found");
    }

    String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";

    Fixed variable name from 'user' to 'username'
    try (Connection conn = DriverManager.getConnection(url, username, password);
       PreparedStatement pstmt = conn.prepareStatement(query)) {

      First Row: Shivek
      pstmt.setString(1, "shivek"); // 1st parameter (name)
      pstmt.setInt(2, 24); // 2nd parameter (age)
     pstmt.setDouble(3, 3343); // 3rd parameter (marks)
     pstmt.executeUpdate(); // Execute first insert

      Second Row: Shobhit
     pstmt.setString(1, "shobhit");
     pstmt.setInt(2, 25);
     pstmt.setDouble(3, 3343);
     pstmt.executeUpdate(); // Execute second insert

     System.out.println("Users were inserted successfully!");
  } catch (SQLException e) {
      e.printStackTrace();
    }

    // Fetch and display data
    try (Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        double marks = rs.getDouble("marks");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("-----------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    query = "UPDATE students SET marks = ? WHERE id = ?";

    try (Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = con.prepareStatement(query)) {

      // new values
      pstmt.setDouble(3, 99.5);

      // which row to update
      pstmt.setInt(4, 1);

      int rowsAffected = pstmt.executeUpdate();

      if (rowsAffected > 0) {
        System.out.println("Student updated successfully!");
      } else {
        System.out.println("No student found.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    // Fetch and display data
    try (Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        double marks = rs.getDouble("marks");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("-----------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
