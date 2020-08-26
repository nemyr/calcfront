package com.example.calcfront.Classes;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calcfront.Classes.Listeners.ActionClickListener;
import com.example.calcfront.Classes.Listeners.DigitsClickListener;
import com.example.calcfront.R;

import java.lang.reflect.Field;

public class ViewManager implements IViewManager {

    private Activity activity;

    private View.OnClickListener digitsClickListener;
    private View.OnClickListener actionClickListener;

    private IActionManager actionManager;

    private TextView tvRequest;
    private TextView tvResponse;

    private Button btnClear;
    private Button btnEqual;
    private Button btnAdd;
    private Button btnSub;

    public ViewManager(Activity context, IActionManager actionManager) {
        this.activity = context;
        this.actionManager = actionManager;

        digitsClickListener = new DigitsClickListener(actionManager);
        actionClickListener = new ActionClickListener(actionManager);

        for (int i = 0; i <= 9; i++) {
            this.activity.findViewById(getResId("btn" + i, R.id.class)).setOnClickListener(digitsClickListener);
        }

        btnClear = this.activity.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(actionClickListener);
        btnEqual = this.activity.findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(actionClickListener);
        btnAdd = this.activity.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(actionClickListener);
        btnSub = this.activity.findViewById(R.id.btnSub);
        btnSub.setOnClickListener(actionClickListener);

        tvRequest = this.activity.findViewById(R.id.tvRequest);
        tvResponse = this.activity.findViewById(R.id.tvResponse);

        updateRequestString("");
        updateResponseString("");
    }

    private int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void lockActions() {
        btnAdd.setEnabled(false);
        btnSub.setEnabled(false);
    }

    public void unlockActions() {
        btnAdd.setEnabled(true);
        btnSub.setEnabled(true);
    }

    public void lockEqual() {
        btnEqual.setEnabled(false);
    }

    public void unlockEqual() {
        btnEqual.setEnabled(true);
    }

    @Override
    public void updateRequestString(String str) {
        tvRequest.setText(str);
    }

    @Override
    public void updateResponseString(String str) {
        tvResponse.setText(str);
    }
}
