package com.example.asynctaskproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mCity;
    //private TextView TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mCity = findViewById(R.id.City);
        //TV = findViewById(R.id.tv_loading);


       /* ImageDownloader img = new ImageDownloader(this);
        img.execute("https://media.northwesternmutual.com/sites/images/hero/original/heroImage_HomePage_Url_Desktop-NY%20Midtown.jpg");*/


       /* ImageDownloader img1 = new ImageDownloader(this);
        EditText et = (EditText)findViewById(R.id.tv_loading);
        img.execute(et.getText().toString());*/
    }

    public void ShowImage(View view) {

        ImageDownloader img = new ImageDownloader(this);
        img.execute("https://media.northwesternmutual.com/sites/images/hero/original/heroImage_HomePage_Url_Desktop-NY%20Midtown.jpg");


        // changed ImageDownloder to get this to work will ask about this later
        //mCity.setVisibility(View.VISIBLE);

    }

    //public void ImageUpload_nextPage(View view) {

       // Intent intent = new Intent(this,ImageShow.class);
      //  String imageURL = mImageUrl.getText().toString();
       // Uri image = Uri.parse(imageURL);

        // MAY NEED TO BE IN SECOND ACTIVITY ON CREATE WITH URL SENT OVER?
        //startActivity(intent);
        //get on first page before next page

    //}


}