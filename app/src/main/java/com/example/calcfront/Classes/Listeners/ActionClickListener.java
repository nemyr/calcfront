package com.example.calcfront.Classes.Listeners;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActionClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(),((Button) view).getText(), Toast.LENGTH_SHORT).show();
    }
}
