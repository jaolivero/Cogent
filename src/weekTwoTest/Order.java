package weekTwoTest;

public class Order {
    private int orderID;

    private String orderType;

    private String orderDescription;
    private String orderStatus;

    public Order(int orderID, String orderType, String orderDescription) {
        this.orderID = orderID;
        this.orderType = orderType;
        this.orderDescription = orderDescription;
    }


    public int getOrderID() {
        return orderID;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String newOrderStatus) throws InvalidStatusException {
        if(newOrderStatus.equalsIgnoreCase("Open") || newOrderStatus.equalsIgnoreCase("Closed")) {
            this.orderStatus = newOrderStatus;
        } else {
            throw new InvalidStatusException();
        }
    }

    @Override
    public String toString() {
        return "Order ID:" + orderID +
                ", Order Type:'" + orderType +
                ", Order Description:'" + orderDescription +
                ", Order Status=: " + orderStatus;
    }
}
