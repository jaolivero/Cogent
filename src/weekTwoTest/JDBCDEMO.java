package weekTwoTest;

import java.sql.*;
import java.util.Scanner;

public class JDBCDEMO {

        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employeeDB";
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASSWORD = "DB2024";

        private static Connection connect() throws SQLException, SQLException {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }

        private static void insertEmployee(Connection conn, int eno, String ename, int ebasic) throws SQLException {
            String sql = "INSERT INTO empy (eno, ename, ebasic) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, eno);
                pstmt.setString(2, ename);
                pstmt.setInt(3, ebasic);

                pstmt.executeUpdate();
                System.out.println("Employee inserted successfully.");
            }
        }

        private static void updateEmployee(Connection conn, int eno, String ename) throws SQLException {
            String sql = "UPDATE empy SET ename = ? WHERE eno = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, ename);
                pstmt.setInt(2, eno);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee updated successfully.");
                } else {
                    System.out.println("Employee not found.");
                }
            }
        }

        private static void deleteEmployee(Connection conn, int eno) throws SQLException {
            String sql = "DELETE FROM empy WHERE eno = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, eno);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee has been deleted successfully.");
                } else {
                    System.out.println("Employee not found.");
                }
            }
        }

        private static void selectCustomers(Connection conn) throws SQLException {
            String sql = "SELECT * FROM empy";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    int eno = rs.getInt("eno");
                    int ebasic = rs.getInt("ebasic");
                    String ename = rs.getString("ename");
                    System.out.println("Employee ID: " + eno + ", Employee Name: " + ename + "Employee Rank:" + ebasic);
                }
            }
        }

        public static void main(String[] args) {
            try (Connection conn = connect(); Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Menu:");
                    System.out.println("1. Insert");
                    System.out.println("2. Update");
                    System.out.println("3. Delete");
                    System.out.println("4. Select");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Employee no: ");
                            int cno = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Employee name: ");
                            String cname = scanner.nextLine();
                            System.out.println("Enter Employee basic");
                            int ebasic = scanner.nextInt();
                            insertEmployee(conn, cno, cname, ebasic);
                            break;
                        case 2:
                            System.out.print("Enter Employee number ");
                            int eno = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter new Employee name: ");
                            String ename = scanner.nextLine();
                            updateEmployee(conn, eno, ename);
                            break;
                        case 3:
                            System.out.print("Enter Employee number: ");
                            eno = scanner.nextInt();
                            deleteEmployee(conn, eno);
                            break;
                        case 4:
                            selectCustomers(conn);
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
