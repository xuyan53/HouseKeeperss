package edu.feicui.app.phone.entity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xy on 2017/1/11.
 */

public class SaveInstance {
    static Context mCtx;
   static SaveInstance saveInstance;
    SharedPreferences sp=null;
    SharedPreferences.Editor et;
    SaveInstance(){
        sp=mCtx.getSharedPreferences("saveState",Context.MODE_PRIVATE);
        et=sp.edit();
    }
    public synchronized static SaveInstance getSaveInstance(Context context){
        mCtx=context;
        if(saveInstance==null){
            return  new SaveInstance();
        }
        return saveInstance;
    }
    public void putStringvalue(String key,String value){
        et.putString(key,value);
        et.commit();
    }
    public String getStringvalue(String key){
        return sp.getString(key,"1");

    }

}
