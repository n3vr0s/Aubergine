package com.n3vr0s.aubergine.library;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EFragment;

import java.lang.ref.WeakReference;

@EFragment
public abstract class AubergineFragment<V extends AubergineView> extends Fragment implements HasPresenter {

    private PresenterFragmentDelegate<AuberginePresenter> presenterDelegate = new PresenterFragmentDelegate<>();
    protected WeakReference<? extends Activity> activityWeakRef;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView();
        try{
            V aubergineView = (V) view;
            presenterDelegate.onCreate(aubergineView.getPresenter(), savedInstanceState);
            presenterDelegate.onViewCreated(view);
        }catch (ClassCastException e){
            throw new RuntimeException("View does not implement expected interface");
        }
        return view;
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

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityWeakRef = new WeakReference<>(activity);
    }

    @Override public void onDetach() {
        super.onDetach();
        activityWeakRef = null;
    }

    @Override public void onResume() {
        super.onResume();
        presenterDelegate.onResume();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        presenterDelegate.onDestroy();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        presenterDelegate.onDestroyView();
    }

    @Override public AuberginePresenter getPresenter() {
        return presenterDelegate.getPresenter();
    }
}
