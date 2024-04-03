import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Java-Final-Sprint";
        String username = "postgres";
        String password = "Amazing@2334";
        Scanner scanner = new Scanner(System.in);

        // Health data input menu
        while (true) {
            System.out.println("\nHealth Data Input Menu");
            System.out.println("1. Daily Activities");
            System.out.println("2. Vital Signs");
            System.out.println("3. Medical Records");
            System.out.println("4. Generate recommendations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputDailyActivities(scanner, jdbcURL, username, password);
                    break;
                case 2:
                    inputVitalSigns(scanner, jdbcURL, username, password);
                    break;
                case 3:
                    inputMedicalRecords(scanner, jdbcURL, username, password);
                    break;
                case 4:
                    List<String> recommendations = generateRecommendations();
                    printRecommendations(recommendations);
                    saveRecommendations(recommendations);
                    break;
                case 5:
                    System.out.println("Exiting Health Data Input. Have a good day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }

    private static void inputDailyActivities(Scanner scanner, String jdbcURL, String username, String password) {
        System.out.println("\nInput Daily Activities: ");
        System.out.print("Enter activity name: ");
        String activityName = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int durationMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        System.out.println("Daily activity entered successfully!");

        saveDailyActivity(activityName, durationMinutes, notes, jdbcURL, username, password);
    }

    private static void saveDailyActivity(String activityName, int durationMinutes, String notes, String jdbcURL, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "INSERT INTO public.\"daily_activities\" (activity_name, duration_minutes, notes) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, activityName);
            preparedStatement.setInt(2, durationMinutes);
            preparedStatement.setString(3, notes);
            preparedStatement.executeUpdate();
            System.out.println("Daily activity saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inputVitalSigns(Scanner scanner, String jdbcURL, String username, String password) {
        System.out.println("\nInput Vital Signs: ");
        System.out.print("Enter heart rate (bpm): ");
        int heartRate = scanner.nextInt();
        scanner.nextLine();
        System.out.print(("Enter blood pressure (e.g., 120/80 mmHg): "));
        String bloodPressure = scanner.nextLine();
        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        

        saveVitalSigns(heartRate, bloodPressure, temperature, notes, jdbcURL, username, password);
    }

    private static void saveVitalSigns(int heartRate, String bloodPressure, double temperature, String notes, String jdbcURL, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "INSERT INTO public.\"vital_signs\" (heart_rate, blood_pressure, temperature, notes) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, heartRate);
            preparedStatement.setString(2, bloodPressure);
            preparedStatement.setDouble(3, temperature);
            preparedStatement.setString(4, notes);
            preparedStatement.executeUpdate();
            System.out.println("Vital signs saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inputMedicalRecords(Scanner scanner, String jdbcURL, String username, String password) {
        System.out.println("\nInput Medical Records: ");
        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter treatment details: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        saveMedicalRecords(diagnosis, treatment, doctorName, notes, jdbcURL, username, password);
    }

    private static void saveMedicalRecords(String diagnosis, String treatment, String doctorName, String notes, String jdbcURL, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "INSERT INTO public.\"medical_records\" (diagnosis, treatment, doctor_name, notes) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diagnosis);
            preparedStatement.setString(2, treatment);
            preparedStatement.setString(3, doctorName);
            preparedStatement.setString(4, notes);
            preparedStatement.executeUpdate();
            System.out.println("Medical record saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static List<String> generateRecommendations() {

        List<String> recommendations = new ArrayList<>();
        recommendations.add("Stay hydrated by drinking at least 8 glasses of water per day.");
        recommendations.add("Aim for 45 minutes of moderate exercise daily.");
        recommendations.add("Get 7-8 hours of quality sleep each night.");
        recommendations.add("Include all kinds of fruits and vegetables into your diet.");
        return recommendations;

    }

    private static void printRecommendations(List<String> recommendations) {
        System.out.println("\nPersonalized Health Recommendations: ");
        System.out.println(recommendations);
    }

    private static void saveRecommendations(List<String> recommendations) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Java-Final-Sprint";
        String username = "postgres";
        String password = "Amazing@2334";

        String sql = "INSERT INTO public.\"personalized_recommendations\" (recommendation_text) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                for (String recommendation : recommendations) {
                    preparedStatement.setString(1, recommendation);
                    preparedStatement.executeUpdate();
                }

                System.out.println("Recommendations saved successfully!");
             } catch (SQLException e) {
                e.printStackTrace();
             }

    }
}
