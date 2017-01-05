package edu.feicui.app.phone.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
    protected void startActivity(){}
}
