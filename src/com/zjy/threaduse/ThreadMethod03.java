package com.zjy.threaduse;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        //守护线程
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        //myDaemonThread.setDaemon(true);

        for (int i = 0; i < 10; i++) {
            System.out.println("宝强");
            Thread.sleep(1000);
        }

    }
}
class MyDaemonThread extends Thread {
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(50);//休眠50毫秒
                 }catch (InterruptedException e) {
                e. printStackTrace() ;
            }
            System.out.println("马蓉和宋歌决乐聊天,哈哈哈~~~");
        }
    }
}
