package oopexam;

interface OrderOperations {
    void placeOrder(String item);
}
interface CancelOperations{
    void cancelOrder(String orderId);
}
class OnlineOrderService implements OrderOperations, CancelOperations{
    @Override
    public void placeOrder(String item){
        System.out.println("Order placed: " + item);
    }

    @Override
    public void cancelOrder(String orderId){
        System.out.println("Oder ceancelled: " + orderId);
    }
}

class OrderClient {
    private final OrderOperations orderOps;

    public OrderClient(OrderOperations orderOps){
        this.orderOps = orderOps;
    }

    public void createNewOrder(){
        orderOps.placeOrder("Book");
    }
}

class CancelClient {
    private final CancelOperations cancelOps;

    public CancelClient(CancelOperations cancelOps){
        this.cancelOps = cancelOps;
    }

    public void cancelOrder(String orderId){
        cancelOps.cancelOrder(orderId);
    }
}

class ISPDemo{
    public static void main(String[] args) {
        OnlineOrderService oos = new OnlineOrderService();

        OrderClient oc = new OrderClient(oos);
        oc.createNewOrder();
        oos.cancelOrder("ORD1234");
    }
}
