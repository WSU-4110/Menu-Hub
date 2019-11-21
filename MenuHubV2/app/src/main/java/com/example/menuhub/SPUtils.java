package com.example.menuhub;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {

    private static final String SP_NAME = "sp";
    private static SharedPreferences sp;

    public static void saveBoolean(Context context, String key, boolean value){
        if(sp == null)
            sp = context.getSharedPreferences(SP_NAME,0);
        sp.edit().putBoolean(key, value).commit();

    }

    public static boolean getBoolean(Context context , String key, boolean defValue){
        if(sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getBoolean(key, defValue);
    }


    public static void saveString(Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,0);
        sp.edit().putString(key, value).commit();
    }
    public static String getString(Context context , String key, String defValue){
        if(sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getString(key, null);
    }

    public static void saveInt(Context context, String key, int value){
        sp = context.getSharedPreferences(SP_NAME,0);
        sp.edit().putInt(key, value).commit();
    }


    public static int getInt(Context context, String key, int value){
        if(sp==null){
            sp = context.getSharedPreferences(SP_NAME,0);
        }
        return sp.getInt(key, 0);
    }




}