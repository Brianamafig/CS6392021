package com.example.databases_test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new Database(this);


        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = mydb.getWritableDatabase();
                db.execSQL(("INSERT INTO student1(name) VALUES ('Mark')"));
                db.execSQL(("INSERT INTO student1(name) VALUES ('Abby')"));
                // Mark and Abby happend twice they have different Ids
                Cursor curl; // ID?
                Cursor curl1;
                String[] idArray = {"id"};
                String[] nameArray = {"name"};
                curl = db.query("student1",idArray,null,null,null,null,null); // Goes through all ID
                curl1 = db.query("student1",nameArray,null,null,null,null,null); // Goes through all names
                //this.startManagingCursor(curl); does not really work not sure why
                curl.moveToFirst();
                curl1.moveToFirst();

                while (!curl.isAfterLast()){

                    Log.i ("MAINACTIVITY", "ID:" + curl.getString(0) + " NAME:" + curl1.getString(0)); // Print all Ids and names
                    curl.moveToNext();
                    curl1.moveToNext();

                }
                curl.close();
                curl1.close();
                db.close();
            }
        }).start();
    }
}