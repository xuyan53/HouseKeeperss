package edu.feicui.app.phone.base.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * Created by xy on 2017/1/10.
 */

public class MemoryUtils {
    public static long getPhoneFreeRamMemory(Context context){
        ActivityManager.MemoryInfo info=new ActivityManager.MemoryInfo();
        ActivityManager am=(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.getMemoryInfo(info);
        return info.availMem;
    }
    public static long getPhoneTotalRamMemory(Context context){
        ActivityManager.MemoryInfo info=new ActivityManager.MemoryInfo();
        ActivityManager am=(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.getMemoryInfo(info);
        return info.totalMem;
    }
//    public static void killAllProcesses(Context context){
//
//        PackageManager packageManager= context.getPackageManager();
//        ActivityManager activityManager=(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//
//        List<ActivityManager.RunningAppProcessInfo> appProcessInfos=activityManager.getRunningAppProcesses();
//
//
//        for(ActivityManager.RunningAppProcessInfo appProcessInfo : appProcessInfos){
//            Log.i("importancesssss","kankankankanfor111111");
//            if(appProcessInfo.importance>=ActivityManager.RunningAppProcessInfo.IMPORTANCE_SERVICE){
//                Log.i("importancesssss","kankankankan");
//                String packageName=appProcessInfo.processName;
//                try {
//
//                    ApplicationInfo applicationInfo=packageManager.getApplicationInfo(packageName,PackageManager.GET_META_DATA|PackageManager.GET_SHARED_LIBRARY_FILES|PackageManager.GET_UNINSTALLED_PACKAGES);
//                   if((applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM)!=0){
////                       activityManager.killBackgroundProcesses(packageName);
////                       Log.i("iffffffffff",applicationInfo.toString());
//
//                    }else {
//                       Log.i("elseeeeeeee",applicationInfo.toString());
//                        activityManager.killBackgroundProcesses(packageName);
//
//                   }
//
//                } catch (PackageManager.NameNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//
//
//    }
public static void killAllProcesses(Context context){
    PackageManager packageManager=context.getPackageManager();
    ActivityManager manager=(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RunningAppProcessInfo> appProcessInfoList=manager.getRunningAppProcesses();
    for(ActivityManager.RunningAppProcessInfo appProcessInfo : appProcessInfoList){
        if(appProcessInfo.importance>= ActivityManager.RunningAppProcessInfo.IMPORTANCE_SERVICE){
            String packageName=appProcessInfo.processName;
            try {
                ApplicationInfo applicationInfo=packageManager.getApplicationInfo(packageName,PackageManager.GET_META_DATA|PackageManager.GET_SHARED_LIBRARY_FILES|PackageManager.GET_UNINSTALLED_PACKAGES);
           if((applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM)!=0){}else {
               manager.killBackgroundProcesses(packageName);
           }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
//        String[] pkgNameList=appProcessInfo.pkgList;
//        for(String pkgName :pkgNameList){
//            Log.e("name",pkgName);
//            try {
//                ApplicationInfo info=packageManager.getApplicationInfo(pkgName,PackageManager.GET_META_DATA|PackageManager.GET_SHARED_LIBRARY_FILES|PackageManager.GET_UNINSTALLED_PACKAGES);
//                Log.i("info",info.toString());
//                if((info.flags&ApplicationInfo.FLAG_SYSTEM)<=0){
//                    Log.i("runningName",info.loadLabel(packageManager).toString());
////                    Log.i("info if",info.toString());
////                    Log.i("pkgName",pkgName);
////                    manager.killBackgroundProcesses(pkgName);
//                }
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }

        }
    }




}
