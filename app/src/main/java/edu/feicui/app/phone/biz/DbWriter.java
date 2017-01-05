package edu.feicui.app.phone.biz;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by xy on 2017/1/3.
 */

public class DbWriter {
    public void read(Context context){
        InputStream is=null;
        OutputStream os=null;
        AssetManager readDb=context.getAssets();
        try {
            is=readDb.open("commonnum.db");

        } catch (IOException e) {
            e.printStackTrace();
        }
        File file=new File("data"+File.separator+"data"+File.separator+"edu.feicui.app.phone"+File.separator+"database");
        File file1=new File("data"+File.separator+"data"+File.separator+"edu.feicui.app.phone"+File.separator+"database"+File.separator+"commonnum.db");
    if(!file.exists()){
        file.mkdirs();

    }
        try {
            file1.createNewFile();
            int len=0;
           os=new FileOutputStream(file1);
            byte[] bt=new byte[1024];
            while((len=is.read(bt))!=-1){
                os.write(bt,0,len);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
