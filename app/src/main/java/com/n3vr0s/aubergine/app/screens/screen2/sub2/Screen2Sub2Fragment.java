package com.n3vr0s.aubergine.app.screens.screen2.sub2;

import android.view.View;

import com.n3vr0s.aubergine.AubergineFragment;

import org.androidannotations.annotations.EFragment;

@EFragment
public class Screen2Sub2Fragment extends AubergineFragment<Screen2Sub2View> {

    @Override protected View createView() {
        return Screen2Sub2RecyclerView_.build(activityWeakRef.get());
    }
}
