package com.n3vr0s.aubergine.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.n3vr0s.aubergine.R;

import de.greenrobot.event.EventBus;
import icepick.Icepick;
import icepick.Icicle;

public abstract class ToolbarAppcompatActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Icicle
    protected String currentFragmentTag;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        createView(savedInstanceState);
        configureToolbar();
    }

    /**
     * View has to implement AubergineView interface
     * @return
     */
    protected abstract void createView(Bundle savedInstanceState);

    protected void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    @Override public void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

}
