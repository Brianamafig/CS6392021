package com.example.midtermbrianafigueroav1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mOutput;
    private EditText mInput;
    private double converter = 1.609;
    private double inputnum;
    private double combined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutput = findViewById(R.id.OutputValue);
        mInput = findViewById(R.id.EnterValue);

    }

    public void ConvertIt(View view) {
        String Holder = mInput.getText().toString(); // try catching but if statements I suck with normal try catch i am sorry I relized I don't need this but I had it the wrong place at first and caused an error
        if(Holder.equals("") || Holder.length() == 0){
            inputnum = 0;
        }else{
            inputnum = Double.parseDouble(Holder);
            Log.i ("MYACTIVITY", "This is number to multiply" + inputnum);
        }
        combined = 1.609 * inputnum;
        mOutput.setText(Double.toString(combined));

    }
}