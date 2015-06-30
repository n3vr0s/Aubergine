package com.n3vr0s.aubergine.app.screens.screen2.sub1;

import android.view.View;

import com.n3vr0s.aubergine.AubergineFragment;

import org.androidannotations.annotations.EFragment;

@EFragment
public class Screen2Sub1Fragment extends AubergineFragment<Screen2Sub1View> {

    @Override protected View createView() {
        return Screen2Sub1RelativeLayout_.build(activityWeakRef.get());
    }
}
