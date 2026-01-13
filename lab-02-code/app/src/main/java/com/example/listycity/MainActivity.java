package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //declare variables here so I'll be able to reference them later
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> dataList;
    Button addButton;

    EditText cityInput;

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

        cityList = findViewById(R.id.city_list);

        //String[]cities = {"Edmonton", "Tokyo", "London", "Sydney", "Moscow"};

        City edmonton = new City("Edmonton");
        City tokyo = new City("Tokyo");

        City[]cities = {edmonton, tokyo};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        //if add button is pressed, add text in the input thingy

        addButton = (Button) findViewById(R.id.addButtonView);
        cityInput = (EditText) findViewById(R.id.userInput);

        ButtonToggler addButtonToggler = new ButtonToggler();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if button is off:
                if (!addButtonToggler.isActivated()){
                    addButton.setText(getString(R.string.confirmMessage));
                }
                //if button is on: create new city, add to cityList
                else {
                    String name = cityInput.getText().toString();//works
                    City newCity = new City(name); //works
                    cityAdapter.add(newCity);
                    addButton.setText(getString(R.string.addButton)); //sets back to default
                    cityInput.setText("");
                }
                addButtonToggler.switchState();
            }
        });


    }
}