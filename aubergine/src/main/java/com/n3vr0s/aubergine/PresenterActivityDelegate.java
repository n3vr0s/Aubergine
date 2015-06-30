package com.n3vr0s.aubergine;

import android.os.Bundle;
import android.view.View;

public class PresenterActivityDelegate<P extends AuberginePresenter> {

    private P presenter;

    public void onCreate(P presenter,Bundle savedInstanceState) {
        this.presenter = presenter;
        presenter.onCreate(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        presenter.onSaveInstanceState(outState);
    }

    protected void onDestroy() {
        presenter.onDestroy();
        presenter.unbindView();
    }

    protected void onResume() {
        presenter.onResume();
    }

    protected void onPause(){
        presenter.onPause();
    }

    public void onViewCreated(View view) {
        try {
            presenter.bindView(view);
        } catch (ClassCastException e) {
            throw new RuntimeException("The view provided does not implement the view interface " +
                    "expected by " + presenter.getClass().getSimpleName() + ".", e);
        }
    }

    public P getPresenter() {
        return presenter;
    }

}
