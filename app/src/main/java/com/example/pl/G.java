package com.example.pl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;

import java.io.File;

public class G extends Application {



    public static Handler handler = new Handler();

    public static Context context;
    public static SQLiteDatabase database;

    public static LayoutInflater inflater;
    public static Activity currentActivity;

    static File rootDataDir;
    public static HelperSQL helperSQL;

    public static String DIR_SDCARD  = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String DIR_DATABASE = DIR_SDCARD + "/databace-PL";

    public static Image getImage(String add){
        return null;
    }
    public static String setImage(Image image){
        return "";
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(context.LAYOUT_INFLATER_SERVICE);





    }



    public void MKDatabase(){
        database = SQLiteDatabase.openOrCreateDatabase(DIR_DATABASE
                + "/database.sqlite",null);

        database.execSQL("CREATE  TABLE IF NOT EXISTS Contact (" +
                "Id INTEGER PRIMARY KEY  NOT NULL  UNIQUE ," +
                " name TEXT check(typeof(name) = 'text') ," +
                " lastName TEXT check(typeof(lastName) = 'text') ," +
                " nickName TEXT check(typeof(nickName) = 'text') ," +
                " gName TEXT check(typeof(gName) = 'text') ," +
                " workAdd TEXT check(typeof(workAdd) = 'text') ," +
                " homeAdd TEXT check(typeof(lastName) = 'text') ," +
                " email TEXT check(typeof(nickName) = 'text') ," +
                " web TEXT check(typeof(gName) = 'text') ," +
                " bdate TEXT check(typeof(workAdd) = 'text') ," +
                " mobile TEXT check(typeof(workAdd) = 'text') ," +
                " phoneWork TEXT check(typeof(workAdd) = 'text') ," +
                " phoneHome TEXT check(typeof(workAdd) = 'text') ," +
                " faxWork TEXT check(typeof(workAdd) = 'text') ," +
                " faxHOme TEXT check(typeof(workAdd) = 'text') ," +
                " other TEXT check(typeof(workAdd) = 'text')" +
                ")");
    }
}
