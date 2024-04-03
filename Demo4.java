import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo4 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Java-Final-Sprint";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Amazing@2334";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String insertQuery = """
                    INSERT INTO public."patient" (first_name, last_name, date_of_birth, gender) VALUES (?, ?, ?, ?)
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Jones");
            preparedStatement.setDate(3, java.sql.Date.valueOf("1997-06-03"));
            preparedStatement.setString(4, "M");
            preparedStatement.executeUpdate();

            System.out.println("Patient data inserted successfully!");

            connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
}
