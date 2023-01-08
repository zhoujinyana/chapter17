package com.zjy.threaduse;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();//启动线程


    }
}
class Cat extends Thread{

    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("miaomiao"+ ++times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 8){
                break;
            }
        }
    }
}