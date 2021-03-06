package com.example.check;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.check.NumbersView;
import com.example.check.NumbersViewAdapter;
import com.example.check.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<NumbersView> arrayList = new ArrayList<NumbersView>();
    NumbersViewAdapter aAdpt;
    Context context;
    //    private Integer[] images = {
//            R.drawable.sample_7, R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7,
//            R.drawable.sample_0, R.drawable.sample_1,
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // create a arraylist of the type NumbersView
//        final ArrayList<NumbersView> arrayList = new ArrayList<NumbersView>();
//        ListView lv = (ListView) findViewById(R.id.listView);
//
//
//        aAdpt = new NumbersViewAdapter(planetsList, this);
//        lv.setAdapter(aAdpt);

//        // React to user clicks on item
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
//                                    long id) {
//
//
//                // We know the View is a <extView so we can cast it
//                TextView clickedView = (TextView) view;
//
//                Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        // add all the values from 1 to 15 to the arrayList
        //the items are of the type NumbersView

//        NumbersView n = new NumbersView("", "");
//        arrayList.add(new NumbersView("1", "One"));
//        arrayList.add(new NumbersView( "2", "Two"));
//        arrayList.add(new NumbersView("3", "Three"));
//        arrayList.add(new NumbersView("4", "Four"));
//        arrayList.add(new NumbersView("5", "Five"));
//        arrayList.add(new NumbersView("6", "Six"));
//        arrayList.add(new NumbersView("7", "Seven"));
//        arrayList.add(new NumbersView("8", "Eight"));
//        arrayList.add(new NumbersView("9", "Nine"));
//        arrayList.add(new NumbersView("10", "Ten"));
//        arrayList.add(new NumbersView("11", "Eleven"));
//        arrayList.add(new NumbersView("12", "Twelve"));
//        arrayList.add(new NumbersView("13", "Thirteen"));
//        arrayList.add(new NumbersView("14", "Fourteen"));
//        arrayList.add(new NumbersView("15", "Fifteen"));
//
//        // Now create the instance of the NumebrsViewAdapter and pass
//        // the context and arrayList created above
//        NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(arrayList, this);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView numbersListView = findViewById(R.id.listView);

//        // set the numbersViewAdapter for ListView
//        numbersListView.setAdapter(numbersArrayAdapter);
//
//        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("error","errortolaunchednewactivity");
//                Toast.makeText(context,"position: "+position,Toast.LENGTH_LONG).show();
//
//                    Intent intent = new Intent(MainActivity.this,ShowI.class);
//                    startActivity(intent);
//
//
//            }
//        });

        Call<List<NumbersView>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<List<NumbersView>>() {
            @Override
            public void onResponse(Call<List<NumbersView>> call, Response<List<NumbersView>> response) {
                List<NumbersView> heroList = response.body();

                Log.d("list size: ", String.valueOf(heroList.size()));
                NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(heroList, MainActivity.this);
                numbersListView.setAdapter(numbersArrayAdapter);
                //Creating an String array for the ListView
//                String[] heroes = new String[heroList.size()];
//
//
//                //looping through all the heroes and inserting the names inside the string array
//                for (int i = 0; i < heroList.size(); i++) {
//                    heroes[i] = heroList.get(i).getNumbersInText() ;
//                }
    }
            @Override
            public void onFailure(Call<List<NumbersView>> call, Throwable t) {
                Log.d("error: ",t.getMessage());
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}