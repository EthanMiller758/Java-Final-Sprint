/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
   
    DatabaseConnecting dbConnection = new DatabaseConnecting();
    public static void main(String[] args) {
        Integer id;
        String firstName;
        String lastName;
        String email;
        String password;
        Boolean isDoctor;
        int option = 0;
        Scanner in = new Scanner(System.in);

        while(option !=-1) {
            System.out.println("Enter id: ");
            id = in.nextInt();
            System.out.println("Enter first name: ");
            firstName = in.nextLine();
            System.out.println("Enter last name: ");
            lastName = in.nextLine();
            System.out.println("Enter email: ");
            email = in.nextLine();
            System.out.println("Enter password: ");
            password = in.nextLine();
            System.out.println("Are you a doctor?");
            isDoctor = in.nextBoolean();
            User p = new User(id,firstName,lastName,email,password,isDoctor);
            option = in.nextInt();
            in.nextLine();
        }
    
        ReadDB();

    }

    public static void ReadDB() {
        ArrayList<User> UserList = new ArrayList<>();
        String query = "SELECT * FROM public.\"User\"";
        try {
            Connection con = DatabaseConnecting.getCon();
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                User p = new User(2, query, query, query, query, false);
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setDoctor(rs.getBoolean("false"));
                UserList.add(p);
            }
        }
            catch(SQLException e) {
                e.printStackTrace();
            }

            for(int i = 0;i<UserList.size();i++) {
                System.out.println(UserList.get(i).toString());
            }
    }
    public static void InsertRecord(User p) {
    
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
 */

