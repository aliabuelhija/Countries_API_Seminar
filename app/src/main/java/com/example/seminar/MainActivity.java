package com.example.seminar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.country.CountryInfoService;
import com.example.country.CountryInfoService.CallBack_Country;

public class MainActivity extends AppCompatActivity {

    private TextView countryInfo;
    private ImageView countryFlag;
    private EditText countryName;
    private CountryInfoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryInfo = findViewById(R.id.country_info);
        countryFlag = findViewById(R.id.country_flag);
        countryName = findViewById(R.id.country_name);
        Button searchButton = findViewById(R.id.search_button);

        service = CountryInfoService.getInstance();

        searchButton.setOnClickListener(this::search);
    }

    private void search(View v) {
        countryInfo.setText("");  // Clear the TextView
        String country = countryName.getText().toString();
        if (!country.isEmpty()) {
            service.findCapitalByName(country, this::showResult);
            service.findRegionByName(country, this::showResult);
            service.findCalingCode(country, this::showResult);
            service.findFlagByName(country, this::loadFlag);

        }
    }

    private void showResult(String result) {
        if (result != null) {
            countryInfo.append(result);
            countryInfo.append("\n");
        }
    }

    private void loadFlag(String flagUrl) {
        Glide.with(this)
                .load(flagUrl)
                .override(240, 180)
                .into(countryFlag);

    }
}
