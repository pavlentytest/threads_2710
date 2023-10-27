package dev1;

public class Main {
    public static void main(String[] args) {
        // процесс
        // поток
        Test thread1 = new Test();
        Test thread2 = new Test();
        thread2.start();
        thread1.start();

        MyTest t1 = new MyTest();
        new Thread(t1).start();
        MyTest t2 = new MyTest();
        new Thread(t2).start();

        Runnable r1 = () -> {
            // логика
        };
        new Thread(r1).start();
        new Thread(() -> System.out.println("123")).start();

    }
}
class Test extends Thread {
    @Override
    public void run() {
        // логика потока!
    }
}
class MyTest implements Runnable {

    @Override
    public void run() {

    }
}