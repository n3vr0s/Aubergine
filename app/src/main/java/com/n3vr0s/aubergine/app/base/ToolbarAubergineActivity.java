package com.n3vr0s.aubergine.app.base;

import android.support.v7.widget.Toolbar;

import com.n3vr0s.aubergine.library.AubergineActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import de.greenrobot.event.EventBus;

@EActivity
public abstract class ToolbarAubergineActivity<S> extends AubergineActivity {

    @ViewById
    protected Toolbar toolbar;

    @AfterViews
    protected void afterViews(){
        getDelegate().setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}
