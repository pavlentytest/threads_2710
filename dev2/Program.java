package dev2;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        //[+]
        //[-]
        //[+][-][+][-]....

        MyThread thread1 = new MyThread("+");
        thread1.start();
        MyThread thread2 = new MyThread("-");
        thread2.start();
        Thread.sleep(3000);
        thread1.flag = false;
        thread1.join(); // ждем завершения
        System.out.print("1-st stopped!");
    }

    public static final Object KEY = new Object();
    public static void printMessage(String str) {
        synchronized (KEY) {
            try {
                System.out.print("[");
                Thread.sleep(500);
                System.out.print(str);
                Thread.sleep(500);
                System.out.print("]");
                //KEY.notify();
               // KEY.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
class MyThread extends Thread {

    public String mess;
    public boolean flag = true;
    MyThread(String m) {
        mess = m;
    }

    @Override
    public void run() {
        while(flag) {
            Program.printMessage(mess);
        }
    }
}
