package com.example.calcfront.Classes.Listeners;

import android.view.View;
import android.widget.Toast;

public class DigitsClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(), view.getTag().toString(), Toast.LENGTH_SHORT).show();
    }
}