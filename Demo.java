import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {
   
    DatabaseConnecting dbConnection = new DatabaseConnecting();
    public static void main(String[] args) {
        User p1 = new User(1, "Ethan", "Miller", "example12@email.com", "Grape", false);

        String query = "INSERT INTO public.\"User\"(id,firstName,lastName,email,password,isDoctor) " + "Values (?,?,?,?,?,?)";

        try {
            Connection con = DatabaseConnecting.getCon();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, p1.getId());
            statement.setString(2,p1.getFirstName());
            statement.setString(3, p1.getLastName());
            statement.setString(4, p1.getEmail());
            statement.setString(5, p1.getPassword());
            statement.setBoolean(6, p1.isDoctor());
            int updateRow = statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}

