package com.zjy.threaduse;

public class Thread02 {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        Thread thread = new Thread(dog);
//        thread.start();

        Tiger tiger = new Tiger();
        Proxy proxy = new Proxy(tiger);
        proxy.start();//静态代理模式
    }
}
class Proxy implements Runnable{
    private Runnable target = null;
    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }//线程代理

    public Proxy(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}
class Animal{}
class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("laohu");
    }
}
class Dog implements Runnable{
int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("hi" + (++count) +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10){
                break;
            }
        }


    }
}