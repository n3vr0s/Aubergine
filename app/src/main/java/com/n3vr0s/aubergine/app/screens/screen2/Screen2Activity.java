package com.n3vr0s.aubergine.app.screens.screen2;

import com.n3vr0s.aubergine.R;
import com.n3vr0s.aubergine.app.base.ToolbarAppcompatActivity;
import com.n3vr0s.aubergine.app.events.NavigateToScreen2Sub2Event;
import com.n3vr0s.aubergine.app.screens.screen2.sub1.Screen2Sub1Fragment_;
import com.n3vr0s.aubergine.app.screens.screen2.sub2.Screen2Sub2Fragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_screen2)
public class Screen2Activity extends ToolbarAppcompatActivity {

    @AfterViews protected void afterViewsScreen2Activity(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, Screen2Sub1Fragment_.builder().build())
                .commit();
    }

    public void onEvent(final NavigateToScreen2Sub2Event navigateToScreen2Event) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, Screen2Sub2Fragment_.builder().build())
                .addToBackStack("transaction")
                .commit();
    }

}
