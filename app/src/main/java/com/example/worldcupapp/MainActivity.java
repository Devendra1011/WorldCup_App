package com.example.worldcupapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Adapter View : listView
        listView = findViewById(R.id.list_view);


        // data Source
        dataModels = new ArrayList<>();

        dataModels.add(new CountryModelClass("Brazil", "5", R.drawable.brazil));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("France", "2", R.drawable.france));
        dataModels.add(new CountryModelClass("Spain", "1", R.drawable.spain));
        dataModels.add(new CountryModelClass("England", "1", R.drawable.unitedkingdom));
        dataModels.add(new CountryModelClass("United States", "0", R.drawable.unitedstates));
        dataModels.add(new CountryModelClass("Saudi Arabia", "0", R.drawable.saudiarabia));


        // adapter
        adapter = new CustomAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Country: " + adapter.getItem(position).getCountry_name()+"\n"+
                        "Win: "+adapter.getItem(position).getWin_count(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}