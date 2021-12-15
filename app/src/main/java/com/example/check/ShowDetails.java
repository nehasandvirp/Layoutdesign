package com.example.check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        TextView tv= findViewById(R.id.textview1);
        ImageView image = findViewById(R.id.img100);
      // View imageView= findViewById(R.id.img1);

        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");

        Log.d("title",Title);


        if(Title!=null)
        {

            tv.setText(Title);
        }
            String URL=intent.getStringExtra("URL");
        try {

            Picasso.get()
                    .load(URL)
                    .fit()
                    .into(image);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}