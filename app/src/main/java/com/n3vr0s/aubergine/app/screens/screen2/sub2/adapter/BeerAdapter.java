package com.n3vr0s.aubergine.app.screens.screen2.sub2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.n3vr0s.aubergine.app.screens.screen2.sub2.Screen2Sub2ViewModel;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> {

    @RootContext
    protected Context context;

    private Screen2Sub2ViewModel.BeerViewModel beer;
    private List<Screen2Sub2ViewModel.BeerViewModel> beers = new ArrayList<>();

    public Screen2Sub2ViewModel.BeerViewModel getItem(int position) {
        return beers.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(BeerItemView_.build(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        beer = getItem(position);
        holder.beerItemView.bindItem(beer);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    public void setList(List<Screen2Sub2ViewModel.BeerViewModel> forms) {
        if (forms == null) {
            forms = new ArrayList<>();
        }
        this.beers = forms;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public BeerItemView beerItemView;

        public ViewHolder(BeerItemView beerItemView) {
            super(beerItemView);
            this.beerItemView = beerItemView;
        }
    }

}