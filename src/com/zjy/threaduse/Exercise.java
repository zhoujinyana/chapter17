package com.zjy.threaduse;

public class Exercise {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new thread());
        thread thread = new thread();
        //new Thread(thread).start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if(i == 5){
                thread1.start();
                thread1.join();

            }
            Thread.sleep(1000);
        }
        System.out.println("主线程结束");

    }
}
class thread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束");

    }
}