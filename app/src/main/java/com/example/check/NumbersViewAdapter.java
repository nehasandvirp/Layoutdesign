package com.example.check;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NumbersViewAdapter extends ArrayAdapter<com.example.check.NumbersView> {

    // invoke the suitable constructor of the ArrayAdapter class
    public NumbersViewAdapter(@NonNull List<NumbersView> context, MainActivity arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(arrayList, 0, context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        com.example.check.NumbersView currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.imageView);
        assert currentNumberPosition != null;
        for(int i=0;i<position;i++) {
            if (position % 2 == 0) {
                //even
                numbersImage.setImageResource(R.drawable.geeks_logo);
                currentItemView.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_green_dark));
            }
            else{
                //odd
                numbersImage.setImageResource(R.drawable.seeks_logo);
                currentItemView.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_orange_light));
            }

        }
//        numbersImage.setImageResource(currentNumberPosition.getNumbersImageId());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(currentNumberPosition.getNumberInDigit());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(currentNumberPosition.getNumbersInText());
        Button button2 = currentItemView.findViewById(R.id.button2);
        textView2.setText(currentNumberPosition.getNumbersInText());

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                try {
                    Toast.makeText(getContext(), "YOU CLICKED ", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        ImageView mImageView;
//        mImageView = new findViewById(R.id.imageViewId);
//        mImageView.setImageResource(R.drawable.seeks_logo);

        // then return the recyclable view
        return currentItemView;
    }
}

