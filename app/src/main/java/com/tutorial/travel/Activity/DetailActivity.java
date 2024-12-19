package com.tutorial.travel.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutorial.travel.Domain.PopularDomain;
import com.tutorial.travel.R;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, locationTxt, scoreTxt, bedTxt, guideTxt, wifiTxt, descriptionTxt;
    private ImageView backBtn, picImg;
    private PopularDomain item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        titleTxt.setText(item.getTitle());
        locationTxt.setText(item.getLocation());
        scoreTxt.setText(""+item.getScore());
        bedTxt.setText(item.getBed()+" bed");

        if(item.isGuide()){
            guideTxt.setText("Guide");
        }else{
            guideTxt.setText("No-Guide");
        }

        if(item.isWifi()){
            wifiTxt.setText("Wi-Fi");
        }else{
            wifiTxt.setText("No Wi-Fi");
        }


        int drawableResourceId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picImg);

        backBtn.setOnClickListener(v -> {
            startActivity(new Intent(DetailActivity.this, MainActivity.class));
        });

    }

    private void initView() {
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        bedTxt = findViewById(R.id.bedTxt);
        guideTxt = findViewById(R.id.guideTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);

        backBtn = findViewById(R.id.backBtn);
        picImg = findViewById(R.id.picImg);

    }
}