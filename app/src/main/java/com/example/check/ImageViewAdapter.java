package com.example.check;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ImageViewAdapter extends ArrayAdapter<com.example.check.ImageViewResponce> {

        List<ImageViewResponce> ImageList;
    public ImageViewAdapter(@NonNull List<ImageViewResponce> context, About arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(arrayList, 0,context);
    }


    @Override
    public View getView(int position,  View view,  ViewGroup parent) {
        View currentItemView = view ;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_about, parent, false);
        }
            ImageViewResponce currentNumberPosition = getItem(position);
            assert currentNumberPosition != null;
            TextView textView1 = currentItemView.findViewById(R.id.textview1);
            textView1.setText(String.valueOf(currentNumberPosition.getAlbumID()));

            TextView textView2 = currentItemView.findViewById(R.id.textview2);
            textView1.setText(String.valueOf(currentNumberPosition.getID()));

            TextView textView3 = currentItemView.findViewById(R.id.textview3);
            textView3.setText(currentNumberPosition.getTitle());


            LinearLayout linearLayout = currentItemView.findViewById(R.id.linearlayout);
            android.widget.ImageView numbersImage = currentItemView.findViewById(R.id.img1);
//            numbersImage.setImageURI(Uri.parse(currentNumberPosition.getURL())) ;
//        Picasso.get().load(currentNumberPosition.getURL()).into(numbersImage);
//
            try {

                Picasso.get()
                        .load(currentNumberPosition.getURL())
                        .fit()
                        .into(numbersImage);
//                view.addview(currentItemView);

            } catch (Exception e) {
                e.printStackTrace();
            }


        LinearLayout iv = currentItemView.findViewById(R.id.linearlayout);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ShowDetails.class);
                intent.putExtra("Title",currentNumberPosition.getTitle());
                intent.putExtra("URL",currentNumberPosition.getURL());
                v.getContext().startActivity(intent);
            }
        });

        return currentItemView;
//"https://via.placeholder.com/600/92c952"  + "https://via.placeholder.com/600/92c952"
//        https://via.placeholder.com/600/92c952https://via.placeholder.com/600/92c952
    }
}
