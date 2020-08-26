package com.example.calcfront.Classes;

public interface IActionManager {
    void actionSetAction(String symbol, String act);

    void actionClear();

    void actionSendRequest();

    void actionAppendDigit(String digit);
}
