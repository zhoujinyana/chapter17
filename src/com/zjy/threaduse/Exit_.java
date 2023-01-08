package com.zjy.threaduse;

public class Exit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(10*1000);
        //通知方式
        t.setLoop(false);
    }
}
class T extends Thread{
   private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T在运行中"+(++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}