package com.example.bloodbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonorPage extends AppCompatActivity {
    // Declaring EditTexts:
    EditText name, phone, address, nextDon, HI;

    // Declaring TextViews:
    TextView lastDon, healthIssue;

    // Declaring CheckBox:
    CheckBox cb;

    // Declaring Spinner:
    Spinner spinner;

    // Declaring ArrayList:
    ArrayList bloodTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_page);

        // Initializing EditTexts:
        name = findViewById(R.id.donorNameET);
        phone = findViewById(R.id.phoneNumET);
        address = findViewById(R.id.addressET);
        nextDon = findViewById(R.id.nextDonationET);
        HI = findViewById(R.id.healthIssuesET);

        // Initializing TextViews:
        lastDon = findViewById(R.id.lastDonationTV);

        // Initializing Spinner and ArrayList:
        spinner = findViewById(R.id.bloodTypeSpinner);
        bloodTypes = new ArrayList();
        bloodTypes.add("Choose");
        bloodTypes.add("A+");
        bloodTypes.add("A-");
        bloodTypes.add("B+");
        bloodTypes.add("B-");
        bloodTypes.add("O+");
        bloodTypes.add("O-");
        bloodTypes.add("AB+");
        bloodTypes.add("AB-");
        ArrayAdapter adapter = new ArrayAdapter(DonorPage.this, android.R.layout.simple_list_item_1, bloodTypes);
        spinner.setAdapter(adapter);

        // Initializing CheckBox;
        cb = findViewById(R.id.healthIssuesCB);
    }


    // choosing last donation:
    public void lastDonClicked(View view) {
        DatePickerDialog dp = new DatePickerDialog(DonorPage.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        lastDon.setText(i + " / " + (i1 + 1) + " / " + i2);
                    }
                },
                2022,
                0,
                1);

        dp.show();
    }


    public void submitClicked(View view) {
        /* Checking information before submitting */
        if(name.getText().toString().equals("")
            || phone.getText().toString().equals("")
                || address.getText().toString().equals("")
                    || spinner.getSelectedItem().toString().equals("Choose")
                        || lastDon.getText().toString().equals("")
                            || nextDon.getText().toString().equals("")
                                || (cb.isChecked() && HI.getText().toString().equals(""))) {

            AlertDialog.Builder alert = new AlertDialog.Builder(DonorPage.this);
            alert.setIcon(R.drawable.alert);
            alert.setTitle("Not all information provided!");
            alert.setMessage("It is ESSENTIAL to provide all required information.");
            alert.setPositiveButton("OKAY!", null);
            alert.show();

        } else {
            // Creating Database:
            DonorDatabase db = Room.databaseBuilder(getApplicationContext(),
                    DonorDatabase.class, "donor-database").allowMainThreadQueries().build();

            BloodDonor donor;

            if(cb.isChecked()) {
                donor = new BloodDonor(name.getText().toString(), Integer.parseInt(phone.getText().toString()),
                        address.getText().toString(), spinner.getSelectedItem().toString(), lastDon.getText().toString(),
                        Integer.parseInt(nextDon.getText().toString()), cb.isChecked(), HI.getText().toString());
            } else {
                donor = new BloodDonor(name.getText().toString(), Integer.parseInt(phone.getText().toString()),
                        address.getText().toString(), spinner.getSelectedItem().toString(), lastDon.getText().toString(),
                        Integer.parseInt(nextDon.getText().toString()), false, "");
            }

            db.donorDAO().insertAll(donor);


            // Making new Toast;
            Toast.makeText(this, "Thanks for submitting form!", Toast.LENGTH_SHORT).show();

            // Getting to new page;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent success = new Intent(DonorPage.this, StartPage.class);
                    startActivity(success);
                }
            }, 2000);
        }
    }
}