package com.example.threebuttons;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowcount;
    private Button Zerobutton;
    private Button Countbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowcount = (TextView) findViewById(R.id.CountText);
        Zerobutton = (Button)findViewById(R.id.Button_zero);
        Countbutton = (Button)findViewById(R.id.Button_count);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void countUp(View view) {
        ++mCount;
        if(mShowcount != null){
            mShowcount.setText(Integer.toString(mCount));
        }
        if(mCount % 2 == 0){
            view.setBackgroundColor(0xff00ff00);
        }

        else {
            view.setBackgroundColor(getResources().getColor(R.color.purple_700));
        }
        if(mCount > 0){
            Zerobutton.setBackgroundColor(Color.RED);
        }

    }

    public void Zero(View view) {
        mCount = 0;
        if(mShowcount != null){
            mShowcount.setText((Integer.toString(mCount)));
        }
        view.setBackgroundColor(Color.LTGRAY);
        Countbutton.setBackgroundColor(getResources().getColor(R.color.purple_700));
    }

    public void Toast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_LONG);
        toast.show();
    }
}