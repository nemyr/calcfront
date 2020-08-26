package com.example.calcfront.Classes;

import android.app.Activity;

public class ActionManager implements IActionManager{

    public static final String actAdd = "add";
    public static final String actSub = "sub";

    private String param1;
    private String param2;
    private String act;

    StringBuilder digitBuilder = new StringBuilder();
    StringBuilder requestBuilder = new StringBuilder();

    IViewManager viewManager;

    public ActionManager(Activity activity){
        this.viewManager = new ViewManager(activity, this);
    }

    public void actionSetAction(String act){
        this.act = act;
        param1 = digitBuilder.length() == 0 ? "0" : digitBuilder.toString();
        digitBuilder.setLength(0);
        requestBuilder.append(act.equals(actAdd) ? " + " : " - ");
        viewManager.updateRequestString(requestBuilder.toString());
        viewManager.lockActions();
        viewManager.unlockEqual();
    }

    public void actionClear(){
        viewManager.unlockActions();
        viewManager.lockEqual();
        digitBuilder.setLength(0);
        requestBuilder.setLength(0);
        viewManager.updateRequestString("");
        viewManager.updateResponseString("");
    }

    public void actionSendRequest(){
        param2 = digitBuilder.length() == 0 ? "0" : digitBuilder.toString();

        viewManager.updateResponseString(param1 + act + param2);
    }

    public void actionAppendDigit(String digit){
        digitBuilder.append(digit);
        requestBuilder.append(digit);
        viewManager.updateRequestString(requestBuilder.toString());
    }
}
