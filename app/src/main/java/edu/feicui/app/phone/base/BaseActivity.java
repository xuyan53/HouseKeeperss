package edu.feicui.app.phone.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.activity.SettingsActivity;

/**
 * Created by xy on 2016/12/27.
 */

public class BaseActivity extends AppCompatActivity{
    protected void startActivity(Class<?> cla){
        Intent intent=new Intent(this,cla);
        startActivity(intent);
    }
    protected void startActivity(Class<?> cla, Bundle bundle){
        Intent intent=new Intent(this,cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        ImageView imageView=(ImageView)findViewById(R.id.img_actionbar1);
        ImageView imageView1=(ImageView)findViewById(R.id.img_actionbar3);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SettingsActivity.class);
            }
        });
    }

    void initActionBar(){
        View actionBarLayout= LayoutInflater.from(this).inflate(R.layout.actionbar_layout,null);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowCustomEnabled(true);

            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayUseLogoEnabled(true);
            ActionBar.LayoutParams params=new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.WRAP_CONTENT);
            actionBar.setCustomView(actionBarLayout,params);
        }
    }


    void changeActionbar(View view){
        ImageView leftImg=(ImageView) view.findViewById(R.id.img_actionbar1);
        TextView centerTxt=(TextView)view.findViewById(R.id.txt_actionbar2);
        ImageView rightImg=(ImageView) view.findViewById(R.id.img_actionbar3);

    }
}
