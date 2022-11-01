package com.example.green_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DBHelper extends SQLiteOpenHelper {

    Context context;

    private static String DB_NAME = "user.db";
    private  static  int DB_VERSION = 1;

    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInBytes;

    private static String createTableQuery = "Create table LoginUser(userName TEXT" +
            ",email TEXT) ";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL(createTableQuery);
        Toast.makeText(context.getApplicationContext(), "table created successfully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void storeData(ModelClass modelClass){
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imageTostoreBitmap = modelClass.getImg();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imageTostoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

        imageInBytes = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName",modelClass.getEdit1());
        contentValues.put("email",modelClass.getEdit2());
        contentValues.put("image",imageInBytes);

        long chekIfQueryRun = db.insert("LoginUser",null,contentValues);
        if(chekIfQueryRun != -1){
            Toast.makeText(context.getApplicationContext(), "Table added successfully", Toast.LENGTH_SHORT).show();
            db.close();
        }
        else{
            Toast.makeText(context.getApplicationContext(), "fail to add", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor getUser(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from LoginUser",null);
        return cursor;
    }
}
