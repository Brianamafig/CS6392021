package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openMap(View view) {
        String loc = "Allan Pavillion";

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intent);

    }

    public void openWeb(View view) {
        String url = "https://www.goodhousekeeping.com/life/pets/g25751355/guinea-pig-breeds/";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't Handle this");
        }
    }

    public void openShare(View view) {
        String txt = "Share the Love";
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share the Love")
                .setText(txt)
                .startChooser();
    }

    public void openMessages(View view) {
        String phone = "525125215";
        String txtMessage = "Hey this is Briana Figueroa";
        Uri message = Uri.parse("smsto:" + phone);
        Intent intent = new Intent(Intent.ACTION_VIEW, message);
        intent.putExtra("sms_body", txtMessage);

        startActivity(intent);
    }

    public void openPhone(View view) {
        String phone = "843992493";
        Uri call = Uri.parse("tel:" + phone);
        Intent intent = new Intent(Intent.ACTION_VIEW, call);
        startActivity(intent);
    }


    public void helpMenu(MenuItem item) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void openNewActivity(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
