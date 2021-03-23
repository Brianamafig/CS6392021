package com.example.employeedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstname;
    private EditText mLastname;
    private TextView mAllName;
    //private DatabaseReference ChildCount;
    private int mcount = 0;
    //private String[] First;
    //private String[] Second;
    private ArrayList<String> First;
    private ArrayList<String> Last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstname = findViewById(R.id.FirstName);
        mLastname = findViewById(R.id.LastName);
        mAllName = findViewById(R.id.AllName);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("employees");


        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot2 : snapshot.getChildren()){
                    Employees employees = snapshot2.getValue(Employees.class);
                    First.add(employees.EmFirstname());
                    Last.add(employees.EmLastName());
                }
                //Employees employees = snapshot.getValue(Employees.class);



                //Log.d("MAINACTIVITY", "Value is: " + Employee);
               // mAllName.setText(Employee.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        //ChildCount = FirebaseDatabase.getInstance().getReference().child("employees");
        //Log.i("MAINACTIVITY", myRef.toString());

        //Log.i("MAINACTIVITY", ChildCount.toString());
    }
}