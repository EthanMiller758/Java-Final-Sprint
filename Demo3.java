public class Demo3 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Java-Final-Sprint";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Amazing@2334";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Scanner scanner = new Scanner(System.in);
        }
    }
}
