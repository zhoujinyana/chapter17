package com.zjy.threaduse;

public class ThreadMethod {
    public static void main(String[] args) {

    }
}
class TT extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}