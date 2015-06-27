package com.n3vr0s.aubergine.app.screens.screen2.sub2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.n3vr0s.aubergine.app.screens.screen2.sub2.adapter.BeerAdapter;
import com.n3vr0s.aubergine.library.AuberginePresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;

import java.util.List;

@EViewGroup
public class Screen2Sub2RecyclerView extends RecyclerView implements Screen2Sub2View {

    @Bean Screen2Sub2Presenter presenter;
    @Bean BeerAdapter adapter;

    public Screen2Sub2RecyclerView(Context context) {
        super(context);
    }

    public Screen2Sub2RecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    protected void afterViews(){
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(adapter);
    }

    @Override public AuberginePresenter getPresenter() {
        return presenter;
    }

    @UiThread
    @Override public void displayBeers(List<Screen2Sub2ViewModel.BeerViewModel> beers) {
        adapter.setList(beers);
        adapter.notifyDataSetChanged();
    }
}
