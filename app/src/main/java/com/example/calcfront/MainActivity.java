package com.example.calcfront;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.calcfront.Classes.ActionManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ActionManager(this);

    }

}