package com.hspedu.exit_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {

        T t1 = new T();
        t1.start();

        //如果希望main线程其控制t1线程的终止，必须可以修改loop
        //让t1退出run方法，从而终止 t1 线程 --》 通知方式

        //让主线程休眠10秒，再通知t1线程腿出
        System.out.println("主线程休眠10s");
        Thread.sleep(10 * 1000); //Add exception to method signature
        t1.setLoop(false);
    }
}

class T extends Thread {

    int count = 0;
    //设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T 运行中" + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
