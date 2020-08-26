package com.example.calcfront.Classes.Listeners;

import android.view.View;
import android.widget.Toast;

import com.example.calcfront.Classes.IActionManager;

public class DigitsClickListener extends BaseListener{

    public DigitsClickListener(IActionManager actionManager) {
        super(actionManager);
    }

    @Override
    public void onClick(View view) {
        actionManager.actionAppendDigit(view.getTag().toString());
    }
}