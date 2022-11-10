package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class DoneePage extends AppCompatActivity {
    Spinner spinner2;
    ArrayList bloodTypes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donee_page);

        spinner2 = findViewById(R.id.bloodTypeSpinner2);
        bloodTypes2 = new ArrayList();
        bloodTypes2.add("Choose");
        bloodTypes2.add("A+");
        bloodTypes2.add("A-");
        bloodTypes2.add("B+");
        bloodTypes2.add("B-");
        bloodTypes2.add("O+");
        bloodTypes2.add("O-");
        bloodTypes2.add("AB+");
        bloodTypes2.add("AB-");
        ArrayAdapter adapter2 = new ArrayAdapter(DoneePage.this, android.R.layout.simple_list_item_1, bloodTypes2);
        spinner2.setAdapter(adapter2);
    }

    // SEARCH Button is clicked:
    public void searchClicked(View view) {
        String btype = spinner2.getSelectedItem().toString();
    }
}