public class Task2 {
    public static void main(String[] args) {
        // 1
        MyThread thread1 = new MyThread();
        thread1.setName("Thread1");
        thread1.setPriority(1);
        thread1.start();

        // 2
        Thread thread2 = new Thread(new MyRunnable());
        thread2.setName("Thread2");
        thread2.setPriority(5);
        thread2.start();

        // 3
        Thread thread3 = new Thread(() -> {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
        });
        thread3.setName("Thread3");
        thread3.setPriority(10);
        thread3.start();
    }
}







class MyThread extends Thread {
    @Override
    public void run() {
//        Thread childThread = Thread.currentThread();
//        childThread.setName("child");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}