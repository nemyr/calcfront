package com.example.calcfront.Classes.Listeners;

import android.view.View;
import android.widget.Button;

import com.example.calcfront.Classes.IActionManager;
import com.example.calcfront.R;

public class ActionClickListener extends BaseListener {

    public ActionClickListener(IActionManager actionManager) {
        super(actionManager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
            case R.id.btnSub:
                actionManager.actionSetAction(((Button) view).getText().toString(), view.getTag().toString());
                break;
            case R.id.btnClear:
                actionManager.actionClear();
                break;
            case R.id.btnEqual:
                actionManager.actionSendRequest();
                break;
        }
    }
}
