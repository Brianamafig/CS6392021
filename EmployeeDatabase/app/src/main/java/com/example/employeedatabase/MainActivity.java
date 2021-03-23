package com.example.employeedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;
import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    public EditText mFirstname;
    public EditText mLastname;
    public TextView mAllName;
    private DatabaseReference myRef;
    private int mcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirstname = findViewById(R.id.FirstName);
        mLastname = findViewById(R.id.LastName);
        mAllName = findViewById(R.id.AllName);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("employees");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = "";
                Employees emp;
                int counter = 0;
                for(DataSnapshot snapshot2 : snapshot.getChildren()){
                    emp =(Employees)snapshot2.getValue(Employees.class);
                    string = string + "First Name: "+ emp.getFirstName()+ ", Last Name: " + emp.getLastName() + "\n";
                    Log.i("MAIN ACTIVITY",counter + "Firstname = "+emp.getFirstName()+" Lastname = " + emp.getLastName());
                    counter++;
                }
                mAllName.setText(string);
                mAllName.setMovementMethod(new ScrollingMovementMethod());
                mcount = counter;
                //Employees employees = snapshot.getValue(Employees.class);



                //Log.d("MAINACTIVITY", "Value is: " + Employee);
               // mAllName.setText(Employee.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The Read Failed" + error.getCode());

            }
        });

        //ChildCount = FirebaseDatabase.getInstance().getReference().child("employees");
        //Log.i("MAINACTIVITY", myRef.toString());

        //Log.i("MAINACTIVITY", ChildCount.toString());
    }

    public void AddEmployee(View view) {
        String fn = mFirstname.getText().toString();
        String Ln = mLastname.getText().toString();
        Employees emp = new Employees(fn, Ln);
        //myRef.push().setValue(emp);
        myRef.child(Integer.toString(mcount)).setValue(emp);
    }
}