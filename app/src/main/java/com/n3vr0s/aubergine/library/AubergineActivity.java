package com.n3vr0s.aubergine.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class AubergineActivity<V extends AubergineView> extends AppCompatActivity implements HasPresenter {

    protected PresenterActivityDelegate<AuberginePresenter> presenterDelegate = new PresenterActivityDelegate<>();

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = createView();
        try{
            V aubergineView = (V) view;
            presenterDelegate.onCreate(aubergineView.getPresenter(), savedInstanceState);
            presenterDelegate.onViewCreated(view);
            setContentView(view);
        }catch (ClassCastException e){
            throw new RuntimeException("View does not implement expected interface");
        }
    }

    /**
     * View has to implement AubergineView interface
     * @return
     */
    protected abstract View createView();

    @Override public void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        presenterDelegate.onSaveInstanceState(outState);
    }

    @Override protected void onResume() {
        super.onResume();
        presenterDelegate.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
        presenterDelegate.onPause();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenterDelegate.onDestroy();
    }

    @Override public AuberginePresenter getPresenter() {
        return presenterDelegate.getPresenter();
    }
}
