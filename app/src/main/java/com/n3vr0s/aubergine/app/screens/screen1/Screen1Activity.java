package com.n3vr0s.aubergine.app.screens.screen1;

import android.view.View;

import com.n3vr0s.aubergine.app.Navigator;
import com.n3vr0s.aubergine.app.base.ToolbarAubergineActivity;
import com.n3vr0s.aubergine.app.events.NavigateToScreen2Event;

import org.androidannotations.annotations.EActivity;

@EActivity
public class Screen1Activity extends ToolbarAubergineActivity<Screen1View> {

    @Override protected View createView() {
        return Screen1RelativeLayout_.build(this);
    }

    public void onEvent(final NavigateToScreen2Event navigateToScreen2Event) {
        Navigator.goToScreen2(this);
    }

}
