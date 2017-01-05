package edu.feicui.app.phone.biz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.entity.PhoneNumber;

/**
 * Created by xy on 2017/1/3.
 */

public class SqliteRead {
    public List<String> readClassList(Context context){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase("data"+ File.separator+"data"+File.separator+"edu.feicui.app.phone"+File.separator+"database"+File.separator+"commonnum.db",null);
        List<String>list=new ArrayList<String>();
        Cursor cursorName=db.query("classlist",new String[]{"name"},null,null,null,null,null);
        while(cursorName.moveToNext()){
            String name=cursorName.getString(0);
            list.add(name);
        }
        db.close();
        return list;
    }
    public List<String>readClassId(Context context){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase("data"+File.separator+"data"+File.separator+"edu.feicui.app.phone"+File.separator+"database"+File.separator+"commonnum.db",null);
        List<String> list=new ArrayList<String>();
        Cursor cursorIdx=db.query("classlist",new String[]{"idx"},null,null,null,null,null);
        while(cursorIdx.moveToNext()){
            int idx=cursorIdx.getInt(0);
            list.add(idx+"");
        }
        db.close();
        return list;
    }
    public List<PhoneNumber> readTables(Context context,String i){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase("data"+File.separator+"data"+File.separator+"edu.feicui.app.phone"+File.separator+"database"+File.separator+"commonnum.db",null);
        List<PhoneNumber> list=new ArrayList<PhoneNumber>();
        Cursor cursorTable=db.query("table"+i,new String[]{"number","name"},null,null,null,null,null);
        while(cursorTable.moveToNext()){
            String number=cursorTable.getString(0);
            String name=cursorTable.getString(1);
            PhoneNumber pn=new PhoneNumber();
            pn.setNumber(number);
            pn.setName(name);
            list.add(pn);

        }
        db.close();
        return list;
    }
}
