import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnecting {

    private static final String url = "jdbc:postgresql://localhost:5432/Java-Final-Sprint";
    private static final String user = "postgres";
    private static final String password = "Amazing@2334";

    public static Connection getCon()
    {
        Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();

        }
        return connection;

    }

    
} 