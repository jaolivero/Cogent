package jdbcTemplateDemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class testJDBC {

    private static EmployeeDAO employeeDAO;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml");
        employeeDAO = context.getBean(EmployeeDAO.class);

        int selection;

        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            System.out.println("Enter your selection");
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    getEmployeeById(scanner);
                    break;
                case 3:
                    getAllEmployees();
                    break;
                case 4:
                    updateEmployeeById(scanner);
                    break;
                    case 5:
                        deleteEmployeeById(scanner);
                        break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }while (selection !=0 );

        scanner.close();

    }

    private static void addEmployee(Scanner scanner) {
        System.out.println("Enter New Employee Details");
        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Age" );
        int age = scanner.nextInt();

        Employee employee = new Employee(id, name, age);
        employeeDAO.insert(employee);
    }

    private static void getEmployeeById(Scanner scanner){
        System.out.println("Enter ID of Employee:");
        int eId = scanner.nextInt();
        Employee employee = employeeDAO.getEmployeeById(eId);
        System.out.println(employee);

        System.out.println(employee.getName() + " has been found");
    }

    private static void getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        System.out.println("All Employees");
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    private static void updateEmployeeById(Scanner scanner) {
        System.out.println("Enter Employee ID your would like to update");
        int idSelected = scanner.nextInt();
        scanner.nextLine();

        Employee currentEmployee = employeeDAO.getEmployeeById(idSelected);
        System.out.println("Enter New Employee Details");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age" );
        int age = scanner.nextInt();
        Employee employee = new Employee(currentEmployee.getId(), name, age);

        employeeDAO.updateById(idSelected, employee);
        System.out.println("Employee has been updated");

    }

    private static void deleteEmployeeById(Scanner scanner) {
        System.out.println("Enter ID to DELETE :");
        int id= scanner.nextInt();

        employeeDAO.deleteById(id);
        System.out.println("Employee has been deleted.");
    }


    private static void printMenu() {
        System.out.println("-------MENU------");
        System.out.println("1 - Add Employee");
        System.out.println("2 - Get Employee By ID");
        System.out.println("3 - Get all Employees");
        System.out.println("4 - Update Employe BY ID");
        System.out.println("5 - Delete Employee BY ID");
        System.out.println("0 - Exiting");
    }
}
