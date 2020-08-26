package com.example.calcfront.Classes;

import android.app.Activity;
import android.widget.TextView;

import com.example.calcfront.R;
import com.example.calcfront.Classes.Listeners.ActionClickListener;
import com.example.calcfront.Classes.Listeners.DigitsClickListener;

import java.lang.reflect.Field;

public class ViewManager {

    private Activity activity;
    private DigitsClickListener digitsClickListener;
    private ActionClickListener actionClickListener;
    private ActionManager actionManager;

    private TextView tvRequest;
    private TextView tvResponse;

    public ViewManager(Activity context){
        this.activity = context;

        digitsClickListener = new DigitsClickListener();
        actionClickListener = new ActionClickListener();

        actionManager = new ActionManager();

        for (int i = 0; i <= 9; i++){
            this.activity.findViewById(getResId("btn" + i,  R.id.class)).setOnClickListener(digitsClickListener);
        }

        this.activity.findViewById(R.id.btnClear).setOnClickListener(actionClickListener);
        this.activity.findViewById(R.id.btnEqual).setOnClickListener(actionClickListener);
        this.activity.findViewById(R.id.btnAdd).setOnClickListener(actionClickListener);
        this.activity.findViewById(R.id.btnSub).setOnClickListener(actionClickListener);

        tvRequest = this.activity.findViewById(R.id.tvRequest);
        tvResponse = this.activity.findViewById(R.id.tvResponse);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
