package com.n3vr0s.aubergine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.androidannotations.annotations.EBean;

import java.lang.ref.WeakReference;

import icepick.Icepick;

@EBean
public abstract class AuberginePresenter<T, V extends AubergineViewModel> implements Presenter<T> {

    protected WeakReference<T> view;
    protected V viewModel;

    @Override public void bindView(T view) { this.view = new WeakReference<>(view); }
    @Override public void unbindView() { this.view = null; }

    @Override public void onCreate(@Nullable Bundle bundle) {
        viewModel = prepareViewModel();
        Icepick.restoreInstanceState(viewModel, bundle);
    }

    @Override public void onResume(){}
    @Override public void onPause() {}
    @Override public void onDestroy() {}

    @Override public void onSaveInstanceState(@NonNull Bundle bundle) {
        Icepick.saveInstanceState(viewModel, bundle);
    }

    protected abstract V prepareViewModel();

    public V getViewModel(){
        return viewModel;
    }

    protected boolean isViewAttached(){
        return view != null && view.get() != null;
    }

}
