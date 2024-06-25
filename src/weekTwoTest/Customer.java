package weekTwoTest;

import java.util.ArrayList;

public class Customer {
    private int customerId;
    private String customerName;

    private ArrayList<Order> orderList = new ArrayList<>();

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.customerName = name;
    }

    public void addNewOrder(Order order){
        orderList.add(order);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void changeOrderStatus(int orderID, String status) throws InvalidStatusException {
        for(Order order: orderList){
            if(order.getOrderID() == orderID) {
                order.setOrderStatus(status);
                System.out.println("test.Order Status has been changed to " + status);
                return;

            }
            else{
                System.out.println("test.Order number " + orderID  +" does not exist!");
            }
        }

    }

    public void printAllOrder(){
        for(Order order: orderList) {
            System.out.println(order);
        }
    }

}
