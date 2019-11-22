package sch.study.test3;
/*
@author 孙朝辉
@create 2019-11-22 下午2:56
@packName sch.study.test3
@sys sunchaohui
@project mybatiStudy

线程学习

*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/*
* 继承Thread
* */
class thread1 extends Thread{
    private static int num;
    thread1(int num){
        thread1.num =num;
    }
    public void run(){
        int i=num,result=0;
        System.out.println("(Thread)new Thread start...");
        while(i>0){
            result+=i;
            i-=1;
        }
        System.out.println("Thread::::"+result);
        System.out.println("(Thread)new Thread end...");
    }
}

/*
* 实现Runnable
* */
class thread2 implements Runnable{
    private static int num;
    private int sleepTime;  //数据在多线程中是共享的，与继承Thread有点不一样
    thread2(int num){
        thread2.num =num;
        sleepTime=(int)(Math.random()*500);
    }
    @Override
    synchronized public void run() {
        int i=num;
        long result=1;
        System.out.println(Thread.currentThread().getName()+"::(Runnable)new Thread start...");
        while(i>0){
            result*=i;
            i-=1;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"::Runnable::::"+result);
        System.out.println(Thread.currentThread().getName()+"::(Runnable)new Thread end...");
        String fileName="javaStudy/thread.txt";
        //结果存盘
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(fileName,true))) {
            writer.write(new Date().toString());
            writer.newLine();
            writer.write(Thread.currentThread().getName()+"::(Runnable)new Thread start...");
            writer.newLine(); //跨平台换行符
            writer.write(Thread.currentThread().getName()+"::Runnable::::"+result);
            writer.newLine(); //跨平台换行符
            writer.write(Thread.currentThread().getName()+"::(Runnable)new Thread end...");
            writer.newLine(); //跨平台换行符
            writer.write(Thread.currentThread().getName()+"共休眠了　"+sleepTime+" S!");  //注意注意注意它的值
            writer.newLine(); //跨平台换行符
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class threadTest1{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main Thread start.......");
//        thread1 t1=new thread1(20000);
//        thread2 t2=new thread2(20);
//        Thread tt=new Thread(t1);
//        Thread ttt=new Thread(t2);
//        ttt.setPriority(6);
//        tt.start();
//        ttt.start();
//        tt.join();
//        ttt.join();
//        try{
//            Thread.sleep(10);//当前线程（即是主线程）休眠
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //数据共享
        thread2 t=new thread2(10);
        new Thread(t,"thread01").start();
        new Thread(t,"thread02").start();
        new Thread(t,"thread03").start();

        System.out.println("main Thread end.......");
    }
}
