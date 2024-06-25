
import weekTwoTest.Customer;
import weekTwoTest.InvalidStatusException;
import weekTwoTest.Order;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidStatusException {
        Scanner sc = new Scanner(System.in);
        Order order = new Order(1234, "Commercial", "Open");
        order.setOrderStatus("Open");
        System.out.println(order.getOrderStatus());
        //order.setOrderStatus("TBD");

        System.out.println("Enter your ID ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your name ");
        String customerName = sc.nextLine();

        Customer customer = new Customer(id, customerName);

        for (int i = 0; i < 2; i++) {
            System.out.println("OrderType:");
            String orderType = sc.nextLine();

            System.out.println("Order Description ");
            String orderDescription = sc.nextLine();

            System.out.println("Order ID: ");
            int orderId = sc.nextInt();

            sc.nextLine();

            System.out.println("Order Processing: Open or Closed");
            String processing = sc.nextLine();

            Order customerOrder = new Order(orderId, orderType, orderDescription);

            customerOrder.setOrderStatus(processing);
            customer.addNewOrder(customerOrder);

        }

        customer.printAllOrder();

    }

}