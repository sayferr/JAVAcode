import java.util.Random;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        NumberGenerator generator = new NumberGenerator();
        Thread generatorThread = new Thread(generator, "Generator");

        NumberWatcher watcher = new NumberWatcher(generatorThread, generator);
        Thread watcherThread = new Thread(watcher, "Watcher");

        System.out.println("State before the start: " + generatorThread.getState()); // New

        generatorThread.start();
        watcherThread.start();

        System.out.println("State after the start: " + generatorThread.getState()); // Runnable

        generatorThread.join();
        watcherThread.join();

        System.out.println("State after completion: " + generatorThread.getState()); // Terminated
    }
}
class NumberGenerator implements Runnable {
    private volatile boolean running = true;
    private int lastNumber;

    public int getLastNumber() {
        return lastNumber;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (running) {
            lastNumber = rand.nextInt(100) + 1;
            System.out.println(Thread.currentThread().getName() + " сгенерировал: " + lastNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Генератор прерван");
                break;
            }
        }
        System.out.println("Генератор остановлен");
    }
}

class NumberWatcher implements Runnable {
    private Thread generatorThread;
    private NumberGenerator generator;

    public NumberWatcher(Thread generatorThread, NumberGenerator generator) {
        this.generatorThread = generatorThread;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (generatorThread.isAlive()) {
            int number = generator.getLastNumber();
            if (number > 90) {
                System.out.println(Thread.currentThread().getName() + ": число > 90, останавливаем генератор");
                generator.stop();
                generatorThread.interrupt();
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Наблюдатель прерван");
                break;
            }
        }
        System.out.println("Наблюдатель завершён");
    }
}
