package com.n3vr0s.aubergine.app;

import android.content.Context;

import com.n3vr0s.aubergine.app.screens.screen2.Screen2Activity_;

public class Navigator {

    private Navigator(){}

    public static void goToScreen2(Context context){
        Screen2Activity_.intent(context).start();
    }
}
