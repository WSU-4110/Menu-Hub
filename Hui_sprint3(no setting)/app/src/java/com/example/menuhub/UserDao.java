package com.example.menuhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// this is for connect database
import java.util.HashMap;

/**
 * User's database table manipulation tool
 */
public class UserDao {
    /**
     * name of database
     */
    public static final String DB_NAME = "user";
    /**
     * database version
     */
    public static final int VERSION = 1;

    private static UserDao sUserDao;

    private SQLiteDatabase db;

    private UserDao(Context context) {
        //create sqlite openhelper public object
        OpenHelper dbHelper = new OpenHelper(context, DB_NAME, null, VERSION);
        //Gets an actionable database object
        db = dbHelper.getWritableDatabase();
    }

    /**
     * get SqliteDB instance
     * @param context
     */
    public synchronized static UserDao getInstance(Context context) {
        if (sUserDao == null) {
            sUserDao = new UserDao(context);
        }
        return sUserDao;
    }

    public ContentValues getContentValues(User user){
        ContentValues cv = new ContentValues();
        cv.put("username", user.username);
        cv.put("userpwd", user.userpwd);
        return cv;

    }



    /**
     * Store the User instance to the database.
     */
    public int  registerUser(User user) {
        if (user != null) {
            Cursor cursor = db .query("User", null, "username=?", new String[]{user.username}, null, null, null);
            //A cursor length greater than 0 indicates that the data already has the user. Registration failed
            if (cursor.getCount() > 0) {
                return -1;
            } else {
                try {
                    //insert database
                    db.insert("User",null,getContentValues(user));
                } catch (Exception e) {
                    Log.d("error", e.getMessage().toString());
                }
                return 1;
            }
        }
        else {
            return 0;
        }
    }



    /**
     * Find the user and verify login
     * @param pwd
     * @param name
     * @return
     */
    public int login(String pwd, String name){
        HashMap<String, String> hashmap=new HashMap<String, String>();
        //Search the database by user name
        Cursor cursor = db .query("User", null, "username=?", new String[]{name}, null, null, null);
        //Greater than 0 indicates the user name
        if (cursor.getCount()>0){
            //Look up the data by username and password
            Cursor pwdcursor = db .query("User", null, "userpwd=?"+" and "+"username=?", new String[]{pwd,name
            }, null, null, null);
            if (pwdcursor.getCount()>0){
                //Indicates that the user is present and the password is correct
                cursor.moveToNext();
                //Returns the id of the user
                return cursor.getInt(cursor.getColumnIndex("id"));
            }else {
                //password incorrect
                return -1;
            }
        }else {
            //the user name is not present
            return -2;
        }


    }
}
