package com.n3vr0s.aubergine;

import android.os.Bundle;
import android.view.View;

public class PresenterFragmentDelegate<P extends AuberginePresenter> {

    private P presenter;
    private boolean isFragmentGoingToBeDestroyed;

    public void onCreate(P presenter,Bundle savedInstanceState) {
        this.presenter = presenter;
        presenter.onCreate(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        isFragmentGoingToBeDestroyed = true;
        if(presenter != null){
            presenter.onSaveInstanceState(outState);
        }
    }

    protected void onResume() {
        presenter.onResume();
        isFragmentGoingToBeDestroyed = false;
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

    public void onDestroyView() {
        presenter.unbindView();
    }

    public void onDestroy() {
        if (!isFragmentGoingToBeDestroyed) {
            presenter.onDestroy();
        }
    }

    public P getPresenter() {
        return presenter;
    }
}
