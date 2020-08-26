package com.example.calcfront.Classes.Listeners;

import android.view.View;

import com.example.calcfront.Classes.IActionManager;

public abstract class BaseListener implements View.OnClickListener {

    protected IActionManager actionManager;

    public BaseListener(IActionManager actionManager) {
        this.actionManager = actionManager;
    }
}
