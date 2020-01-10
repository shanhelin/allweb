package com.b505.manyThread;

/**
 * 描述：第一个线程写入input用户，另一个线程读取out用户，实现一个读一个写操作
 * author：yulin
 * Create date：2020-1-10 17:82
 *
 *
 *
 *
 *
 */
public class ThreadDemo1 {

    public  static void  main(String [] agrs){

        Res res=new Res();

        InThread inThread=new InThread( res );
        OutThread outThread=new OutThread( res );

        //该代码会发生线程错乱，造成线程安全问题
        inThread.start();
        outThread.start();

    }

}
