package com.zjy.threaduse;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        E e = new E();
        e.start();
        for (int i = 0; i <= 20 ; i++) {
            Thread.sleep(1000);
            System.out.println("主线");
            if(i == 5){
                e.join();//子线程插队
            }

        }
    }
}
class E extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
        try {
            Thread.sleep(50);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "JoinThread------" +i);
    }
  }
}
