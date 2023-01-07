package com.geektechkb.android34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektechkb.android34.fragment.NameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new NameFragment()).commit();

    }
}