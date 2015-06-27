package com.n3vr0s.aubergine.app.screens.screen2.sub2.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.n3vr0s.aubergine.R;
import com.n3vr0s.aubergine.app.screens.screen2.sub2.Screen2Sub2ViewModel;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.view_item_beer)
public class BeerItemView extends CardView {

    @ViewById
    ImageView ivLogo;
    @ViewById
    TextView tvBeerName;

    public BeerItemView(Context context) {
        super(context);
        init();
    }

    protected void init(){
        setMaxCardElevation(getResources().getDimension(R.dimen.card_elevation));
        setRadius(getResources().getDimension(R.dimen.card_corner_radius));
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = (int) getResources().getDimension(R.dimen.card_margin);
        layoutParams.setMargins(margin, margin, margin, margin);

        setLayoutParams(layoutParams);
    }

    public void bindItem(Screen2Sub2ViewModel.BeerViewModel beer) {
        if(!TextUtils.isEmpty(beer.logoUrl)){
            Picasso.with(getContext()).load(beer.logoUrl).into(ivLogo);
        }
        tvBeerName.setText(beer.name);
    }
}
