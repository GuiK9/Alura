package org.exampleMonitor.t2;

class MonitorDemo{
    synchronized void showMsg(String  msg){ //synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(msg);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
class  Thread1 extends Thread{
    MonitorDemo m;
    Thread1(MonitorDemo m){
        this.m=m;
    }
    public void run(){
        m.showMsg("thread1");
    }
}
class  Thread2 extends Thread{
    MonitorDemo m;
    Thread2(MonitorDemo m){
        this.m=m;
    }
    public void run(){
        m.showMsg("thread2");
    }
}
public class SimpleTesting{
    public static void main(String[] args){
        MonitorDemo obj = new MonitorDemo();
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }
}
