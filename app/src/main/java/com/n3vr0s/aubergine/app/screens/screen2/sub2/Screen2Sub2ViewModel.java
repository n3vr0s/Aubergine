package com.n3vr0s.aubergine.app.screens.screen2.sub2;

import com.n3vr0s.aubergine.app.communications.pojos.BeerPojo;
import com.n3vr0s.aubergine.library.AubergineViewModel;

import java.util.ArrayList;

import icepick.Icicle;

public class Screen2Sub2ViewModel extends AubergineViewModel {

    @Icicle ArrayList<BeerViewModel> beers = new ArrayList<>();

    public Screen2Sub2ViewModel() {

    }

    public static BeerViewModel transform(BeerPojo beerPojo) {
        String link = "";
        if(beerPojo.labels != null){
            link = beerPojo.labels.medium;
        }
        return new BeerViewModel(beerPojo.name, link);
    }

    public static class BeerViewModel {
        @Icicle public String name;
        @Icicle public String logoUrl;

        public BeerViewModel(String name, String logoUrl) {
            this.name = name;
            this.logoUrl = logoUrl;
        }
    }

}
