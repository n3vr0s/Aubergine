package com.n3vr0s.aubergine.app;

import android.content.Context;
import android.content.Intent;

import com.n3vr0s.aubergine.app.screens.screen2.Screen2Activity;

public class Navigator {

    private Navigator(){}

    public static void goToScreen2(Context context){
        Intent intent = new Intent(context, Screen2Activity.class);
        context.startActivity(intent);
    }
}
