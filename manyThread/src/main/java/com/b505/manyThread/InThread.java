package com.b505.manyThread;

/**
 * 描述：向设置线程资源输入资源
 * author：yulin
 * Create date 2020-1-10 17:42
 */
public class InThread extends Thread {

    private Res res;

    public InThread(Res res){

        this.res=res;

    }

    @Override
    public synchronized void run(){
        int count =0;
        while (true){
            if(count==0){
                res.setUserName( "小单" );
                res.setUserSex( "男" );
            }else{
                res.setUserSex( "女" );
                res.setUserName( "小红" );
            }
            count=(count+1)%2;

        }
    }
}
