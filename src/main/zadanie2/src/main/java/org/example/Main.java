import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();
        Random random = new Random();


        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) { //
                    Order order = new Order(i, "ShoeType" + (random.nextInt(5) + 1), random.nextInt(10) + 1);
                    warehouse.receiveOrder(order);
                    Thread.sleep(100); //
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });


        int consumerCount = 4;
        for (int i = 0; i < consumerCount; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 5; j++) {
                        warehouse.fulfillOrder();
                        Thread.sleep(150);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        producer.start();
    }
}
