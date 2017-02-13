package edu.feicui.app.phone.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by xy on 2017/1/9.
 */

public class ProportionThread implements Runnable {

    String trans;
    int i=0;
    int j=0;
    int ij=0;
    Handler handler;
    boolean flag=true;
    public  ProportionThread(int ij,Handler handler){
        this.ij=ij;
        this.handler=handler;

    }
    @Override
    public void run() {
        while(flag){

            if(i<=100){
                trans=(i++)+"%";
            }

            if(i>=101){
                i=100;




                trans=(j++)+"%";

            }

            Message msg=new Message();
            Bundle bundle=new Bundle();
            bundle.putString("info",trans);
            msg.setData(bundle);
            msg.what=1;
            handler.sendMessage(msg);

            if(i==100&&j==ij){
                flag=false;
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
