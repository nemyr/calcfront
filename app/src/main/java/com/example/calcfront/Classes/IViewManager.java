package com.example.calcfront.Classes;

public interface IViewManager {
    void lockActions();

    void unlockActions();

    void lockEqual();

    void unlockEqual();

    void updateRequestString(String str);

    void updateResponseString(String str);

    void lockDigits();

    void unlockDigits();
}
