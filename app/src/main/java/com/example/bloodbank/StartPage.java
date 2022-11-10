package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class StartPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }

    // If user is Donor:
    public void isDonor(View view) {
        Intent donorPage = new Intent(StartPage.this, DonorPage.class);
        startActivity(donorPage);
    }

    // If user is Donee:
    public void isDonee(View view) {
        Intent doneePage = new Intent(StartPage.this, DoneePage.class);
        startActivity(doneePage);
    }


    // Additional information is clicked:
    public void additionalInformation(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.blood.co.uk/who-can-give-blood/"));
        startActivity(urlIntent);
    }

}