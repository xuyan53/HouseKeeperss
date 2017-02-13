package edu.feicui.app.phone.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.base.util.MemoryUtils;
import edu.feicui.app.phone.thread.ProportionThread;
import edu.feicui.app.phone.view.DrawCycleView;

public class HomeActivity extends BaseActivity {
    ImageView mIgvAllContacts;
    DrawCycleView mDcv_show;
    ImageView mImvCycle;
    TextView mTxtProportion;
    ImageView mImgJumpToSoft;
    Context ctx;
    float sum=0;
    float available=0;
    float proportion=0;
    float rac=0;
    int ij=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mIgvAllContacts=(ImageView) findViewById(R.id.iv_allcontacts);
        ctx=this;
        mIgvAllContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,AllContactsActivity.class);
                startActivity(intent);
            }
        });
        mDcv_show=(DrawCycleView) findViewById(R.id.dcv_cycle);
//        mDcv_show.setParamWithAnim(360,-270);
        mTxtProportion=(TextView)findViewById(R.id.txt_proportion);
        mImvCycle=(ImageView)findViewById(R.id.imv_cycle);
        mImgJumpToSoft=(ImageView)findViewById(R.id.img_jump_to_softmanage);
        mImgJumpToSoft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,SoftwareManageActivity.class);
                startActivity(intent);
            }
        });
//        File file= Environment.getDataDirectory();
//        StatFs sfs=new StatFs(file.getAbsolutePath());
//        available=sfs.getAvailableBlocks();
//        Log.i("availeble######",available+"");
//        sum=sfs.getBlockCount();
//        Log.i("sum######",sum+"");
//        proportion=available/sum;
//        rac=-(360*proportion);
//        ij=(int) (proportion*100);
//        Log.i("rac######",rac+"");
//        Log.i("ij#######",ij+"");
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        Bundle bundle=msg.getData();
                        String info=bundle.get("info").toString();
                        mTxtProportion.setText(info);
                        break;
                }
            }
        };
     mImvCycle.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             MemoryUtils.killAllProcesses(ctx);

             available= MemoryUtils.getPhoneFreeRamMemory(ctx);
             Log.i("availeble######",available+"");
             sum=MemoryUtils.getPhoneTotalRamMemory(ctx);
             Log.i("sum######",sum+"");
             proportion=available/sum;
             rac=-(360*proportion);
             ij=(int) (proportion*100);
             Log.i("rac######",rac+"");
             Log.i("ij#######",ij+"");

             mDcv_show.setParamWithAnim(360,rac);
             ProportionThread pt=new ProportionThread(ij,handler);
             Thread td=new Thread(pt);
             td.start();
             mDcv_show.setff(0,0);

         }
     });

    }
}
