public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        long satrtSequential = System.currentTimeMillis();
        countNumbers();
        countStars();
        long endSequential = System.currentTimeMillis();
        System.out.println("Sequential time: " + (endSequential - satrtSequential));


        Thread t1 = new Thread(Task1::countNumbers);
        Thread t2 = new Thread(Task1::countStars);

        long startParallel = System.currentTimeMillis();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endParallel - startParallel));
    }

    static void countNumbers(){
        for (int i = 0; i <= 10000; i++) {
            System.out.print(i + " ");
        }
    }

    static void countStars(){
        for (int i = 0; i <= 5000; i++) {
           System.out.print("*" + " ");
        }
    }
}
