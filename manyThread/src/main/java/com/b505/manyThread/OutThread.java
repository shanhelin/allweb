package com.b505.manyThread;

/**
 * 描述：输出线程信息
 * author：yulin
 * Create date 2020-1-10 17:43
 */
public class OutThread extends Thread {

    private Res res;

    public OutThread(Res res){

        this.res=res;

    }

    @Override
    public synchronized void run(){
        while (true){

            System.out.println( res.getUserName()+"--"+res.getUserSex() );
        }
    }
}
