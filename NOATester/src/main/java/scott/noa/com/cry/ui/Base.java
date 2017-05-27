package scott.noa.com.cry.ui;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import scott.noa.com.cry.util.CSVUtils;

/**
 * Created by noalabs on 2017/5/13.
 */

public class Base extends AppCompatActivity {


    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private final static String LOG_TAG = Base.class.getName();

    public void setIntKey(SharedPreferences sp,String key,int value){
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public int getIntKey(SharedPreferences sp,String key){
        int id=sp.getInt(key,1);
        setIntKey(sp,key,id+1);
        return id;
    }

    public boolean getBoolKey(SharedPreferences sp,String key){
        return sp.getBoolean(key,true);
    }

    public void setBoolKey(SharedPreferences sp,String key,boolean value){
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }


    private boolean appendContent(String fileName,String content){
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isSD(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public boolean folder(String name,StringBuffer context){
        String path=Environment.getExternalStorageDirectory()+"/NOATesting";
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        path = path+"/"+name;

        file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        File saveFile = new File(file,name+"-"+sdf.format(System.currentTimeMillis())+".csv");

        if(name.equalsIgnoreCase("FenSens")){
            if(!saveFile.exists()){
                //写入数据
                context.insert(0,"id,name,mac,left,right,v,rssi\r");
            }
        }else if(name.equalsIgnoreCase("Button")){
            if(!saveFile.exists()){
                //写入数据
                context.insert(0,"id,name,mac,data,rssi\r");
            }
        }else if(name.equalsIgnoreCase("Cashew")){
            if(!saveFile.exists()){
                //写入数据
                context.insert(0,"id,name,mac,rssi,battery,state\r");
            }
        }
        context.append("\r");
        boolean isSuccess = appendContent(saveFile.getAbsolutePath(),context.toString());
        return isSuccess;
    }

}
