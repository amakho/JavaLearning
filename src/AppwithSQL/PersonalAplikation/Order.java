package AppwithSQL.PersonalAplikation;

interface Order {
    void processOrder(String contentOrders);
}
class OrderInside implements Order {
    private int numberOfTable;

    public  OrderInside(int numberOfTable){
        this.numberOfTable = numberOfTable;
    }

    @Override
    public void processOrder(String contentOrders) {
        System.out.println("Your order (" + contentOrders + ") ready for table nr " + numberOfTable);
    }
}
class DeliveryOrder implements Order {
    private String deliveryAdress;
    public DeliveryOrder(String deliveryAdress){
        this.deliveryAdress = deliveryAdress;
    }

    @Override
    public void processOrder(String contentOrders) {
        System.out.println("Preparing your order " + contentOrders);
        System.out.println("Packing your order.");
        System.out.println("Courier is on way to you "+ deliveryAdress);
    }
}
class OrderOutside implements Order{
    private String clientsnumber;
    public OrderOutside(String clientsnumber){
        this.clientsnumber = clientsnumber;
    }

    @Override
    public void processOrder(String contentOrders) {
        System.out.println("Order " + contentOrders + " is ready for nr " + clientsnumber);
    }
}
