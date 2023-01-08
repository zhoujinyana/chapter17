package com.zjy.threaduse;

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        //会出现超卖的现象
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
    }
}
class SellTicket01 extends Thread {
    private static int num = 100;
    private boolean loop = true;

    public/* synchronized*/ void m() {
        synchronized (this) {//这里不是同一个对象，所以锁不住,会超卖sellTicket01，sellTicket02，sellTicket03
            if (num <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--num));
        }
    }


    @Override
    public void run() {//同步
        while (loop) {
            m();

        }

    }
}
    class SellTicket02 implements Runnable {
        private int num = 100;
        private boolean loop = true;

        @Override
        public void run() {
            while (loop) {
                sell();
            }
        }

        public void sell() {
            synchronized (this) {//同一个对象，不会超卖sellTicket02
                if (num <= 0) {
                    System.out.println("售票结束");
                    loop = false;
                    return;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--num));
            }
        }
    }