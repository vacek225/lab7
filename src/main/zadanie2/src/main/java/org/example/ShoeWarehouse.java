import java.util.LinkedList;
import java.util.List;

public class ShoeWarehouse {
    private static final int MAX_CAPACITY = 10; //
    private final List<Order> orders = new LinkedList<>();


    public synchronized void receiveOrder(Order order) throws InterruptedException {
        while (orders.size() >= MAX_CAPACITY) {
            wait(); //
        }
        orders.add(order);
        System.out.println("Received: " + order);
        notifyAll(); //
    }


    public synchronized Order fulfillOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            wait(); //
        }
        Order order = orders.remove(0);
        System.out.println("Fulfilled: " + order);
        notifyAll(); //
        return order;
    }
}
