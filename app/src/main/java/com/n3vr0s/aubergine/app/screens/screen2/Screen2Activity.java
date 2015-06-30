package com.n3vr0s.aubergine.app.screens.screen2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.n3vr0s.aubergine.app.R;
import com.n3vr0s.aubergine.app.base.ToolbarAppcompatActivity;
import com.n3vr0s.aubergine.app.events.NavigateToScreen2Sub2Event;
import com.n3vr0s.aubergine.app.screens.screen2.sub1.Screen2Sub1Fragment_;
import com.n3vr0s.aubergine.app.screens.screen2.sub2.Screen2Sub2Fragment_;

public class Screen2Activity extends ToolbarAppcompatActivity {

    @Override protected void createView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_screen2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);

        if(currentFragment == null){
            currentFragmentTag = "SUB1";
            fragmentManager
                .beginTransaction()
                .replace(R.id.root, Screen2Sub1Fragment_.builder().build(), currentFragmentTag)
                .commit();
        }

    }

    public void onEvent(final NavigateToScreen2Sub2Event navigateToScreen2Event) {
        currentFragmentTag = "SUB2";
        getSupportFragmentManager()
            .beginTransaction()
                .replace(R.id.root, Screen2Sub2Fragment_.builder().build(), currentFragmentTag)
            .addToBackStack(null)
            .commit();
    }

}
