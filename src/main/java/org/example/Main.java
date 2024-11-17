public class Main {
    public static void main(String[] args) {
        Thread evenThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i += 2) {
                    System.out.println("Even Thread: " + i);
                }
            }
        };


        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd Thread: " + i);
            }
        });

        evenThread.start();
        oddThread.start();
    }
}