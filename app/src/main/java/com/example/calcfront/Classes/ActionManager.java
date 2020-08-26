package com.example.calcfront.Classes;

import android.app.Activity;

public class ActionManager implements IActionManager {

    private String param1;
    private String param2;
    private String act;

    StringBuilder digitBuilder = new StringBuilder();
    StringBuilder requestBuilder = new StringBuilder();

    IViewManager viewManager;

    public ActionManager(Activity activity) {
        this.viewManager = new ViewManager(activity, this);
    }

    public void actionSetAction(String symbol, String act) {
        this.act = act;
        param1 = digitBuilder.length() == 0 ? "0" : digitBuilder.toString();
        digitBuilder.setLength(0);
        requestBuilder.append(symbol);
        viewManager.updateRequestString(requestBuilder.toString());
        viewManager.lockActions();
        viewManager.unlockEqual();
    }

    public void actionClear() {
        viewManager.unlockActions();
        viewManager.lockEqual();
        digitBuilder.setLength(0);
        requestBuilder.setLength(0);
        viewManager.updateRequestString("");
        viewManager.updateResponseString("");
        viewManager.unlockDigits();
    }

    public void actionSendRequest() {
        param2 = digitBuilder.length() == 0 ? "0" : digitBuilder.toString();
        RequestSender requestSender = new RequestSender(param1, param2, act, this);
        requestSender.execute();
    }

    public void actionAppendDigit(String digit) {
        digitBuilder.append(digit);
        requestBuilder.append(digit);
        viewManager.updateRequestString(requestBuilder.toString());
    }

    @Override
    public void showResult(String result) {
        viewManager.updateResponseString(result);
        viewManager.unlockActions();
        viewManager.lockEqual();
        viewManager.lockDigits();
        viewManager.lockActions();
    }

    public void actionCancel() {
        viewManager.showError("Что-то пошло не так");
    }
}
