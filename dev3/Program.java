package dev3;

public class Program {

    private volatile boolean flag;
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stop gui!");
            flag = true;
        }
    };
    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // логика
            }
            System.out.println("Stop logic!");
        }
    };


    public static void main(String[] args) {
        //  промоделируем работу игрового приложение
        // два потока: 1 поток - GUI, 2 поток - логика игры
        new Program().doStart();
    }

    void doStart() {
        new Thread(gui).start();
        System.out.println("Start gui!");
        new Thread(logic).start();
        System.out.println("Start logic!");
    }


}
