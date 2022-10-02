package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.custom_listview.databinding.ActivityMainBinding;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,

        R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
    String[] name = {"Chris Hemsworth","Karan Kapoor","Abhishek Singh","Arjun Kumar","Mikey Jordan","Michael Smith","Rakhi Pandey","Chris Evans","S. Alexa"};
    String[] phoneNo = {"7656610000","8000023344", "9993872637","634824827","6823516428","7816415247","3781269134","2718361528",
            "9138273622", "9208342611"};
    String[] country = {"United States","Russia","India","Israel","Germany","Thailand","Canada","France","Switzerland"};
        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);

        }
        
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener((parent, view, position, id) -> {

            Intent i = new Intent(MainActivity.this,UserActivity.class);
            i.putExtra("name",name[position]);
            i.putExtra("phone",phoneNo[position]);
            i.putExtra("country",country[position]);
            i.putExtra("imageid",imageId[position]);
            startActivity(i);

        });

    }
}