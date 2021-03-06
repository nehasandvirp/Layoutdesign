package com.example.check;

import static android.graphics.Color.*;

import static com.example.check.R.color.blue;
import static com.example.check.R.color.green;
import static com.example.check.R.color.red;
import static com.example.check.R.color.white;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

    public  class NumbersViewAdapter extends ArrayAdapter<com.example.check.NumbersView> {

        // invoke the suitable constructor of the ArrayAdapter class
        public NumbersViewAdapter(@NonNull List<NumbersView> context, MainActivity arrayList) {

            // pass the context and arrayList for the super
            // constructor of the ArrayAdapter class
            super(arrayList, 0, context);
        }

//    public DAR_Aadapter(Context getContext, ArrayList<DAR_List_Item> dar_List_Items) {
//
//        // TODO Auto-generated constructor stub
//        int color_array[];
//        this.activity=activity;
//        this.dar_List_Items=dar_List_Items;
//        color_array=getContext().getResources().getIntArray(R.array.dar_list_color);
//
//    }



        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        Color[] colors;
//        colors = new Color[]{
//
////
//                colors[0] = new Color(red);
//        colors[1] = new Color(blue);
//        colors[2] = new Color(green);
//        colors[3] = new Color(white);
//

            View currentItemView = convertView;
            // convertView which is recyclable view


            // of the recyclable view is null then inflate the custom layout for the same
            if (currentItemView == null) {
                currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
            }

            // get the position of the view from the ArrayAdapter
            NumbersView currentNumberPosition = getItem(position);

            // then according to the position of the view assign the desired image for the same
            ImageView numbersImage = currentItemView.findViewById(R.id.imageView);
            assert currentNumberPosition != null;
            if (position % 2 == 0) {
                //even
                numbersImage.setImageResource(R.drawable.geeks_logo);
                currentItemView.setBackgroundColor(getContext().getResources().getColor(R.color.red));
                if (position % 4 == 0) {
                    currentItemView.setBackgroundColor(getContext().getResources().getColor(R.color.green));
                }
            }
            else {
                //odd
                numbersImage.setImageResource(R.drawable.seeks_logo);
                if (position % 3 == 0) {
                    currentItemView.setBackgroundColor(getContext().getResources().getColor(R.color.blue));
                } else {
                    currentItemView.setBackgroundColor(getContext().getResources().getColor(R.color.purple_200));
                }
            }



            // numbersImage.setImageResource(currentNumberPosition.getNumbersImageId());

            // then according to the position of the view assign the desired TextView 1 for the same
            TextView textView1 = currentItemView.findViewById(R.id.textview1);
            textView1.setText(String.valueOf(currentNumberPosition.getNumberInDigit()));

            // then according to the position of the view assign the desired TextView 2 for the same
            TextView textView2 = currentItemView.findViewById(R.id.textview2);
            textView2.setText(currentNumberPosition.getNumbersInText());

            Log.d("list email: ", currentNumberPosition.getEmail());
            Log.d("list username: ", currentNumberPosition.getUsername());
            TextView textView3 = currentItemView.findViewById(R.id.textview3);
            textView3.setText(currentNumberPosition.getEmail());

            TextView textView4 = currentItemView.findViewById(R.id.textview4);
            textView4.setText(currentNumberPosition.getUsername());

            Button button2 = currentItemView.findViewById(R.id.button2);
//            textView2.setText(currentNumberPosition.getUsername());
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                    Toast.makeText(getContext(), "YOU CLICKED ", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            });


            Button btn = currentItemView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d("button:","button disable");
                    Intent intent = new Intent(v.getContext(),About.class);
                    v.getContext().startActivity(intent);
                }
            });


//            Intent intent = getIntent();
//            try{
//
//                if (intent!=null) {
//                }
//
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//Listview starts




            // then return the recyclable view
            return currentItemView;

        }

    }
