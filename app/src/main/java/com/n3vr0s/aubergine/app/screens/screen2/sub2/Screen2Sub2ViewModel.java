package com.n3vr0s.aubergine.app.screens.screen2.sub2;

import android.os.Parcel;
import android.os.Parcelable;

import com.n3vr0s.aubergine.app.communications.pojos.BeerPojo;
import com.n3vr0s.aubergine.AubergineViewModel;

import java.util.ArrayList;

public class Screen2Sub2ViewModel extends AubergineViewModel implements Parcelable {

    ArrayList<BeerViewModel> beers = new ArrayList<>();

    public Screen2Sub2ViewModel() {

    }

    public static BeerViewModel transform(BeerPojo beerPojo) {
        String link = "";
        if(beerPojo.labels != null){
            link = beerPojo.labels.medium;
        }
        return new BeerViewModel(beerPojo.name, link);
    }

    public static class BeerViewModel implements Parcelable {
        public String name;
        public String logoUrl;

        public BeerViewModel(String name, String logoUrl) {
            this.name = name;
            this.logoUrl = logoUrl;
        }


        @Override public int describeContents() {
            return 0;
        }

        @Override public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.logoUrl);
        }

        protected BeerViewModel(Parcel in) {
            this.name = in.readString();
            this.logoUrl = in.readString();
        }

        public static final Creator<BeerViewModel> CREATOR = new Creator<BeerViewModel>() {
            public BeerViewModel createFromParcel(Parcel source) {
                return new BeerViewModel(source);
            }

            public BeerViewModel[] newArray(int size) {
                return new BeerViewModel[size];
            }
        };
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(beers);
    }

    protected Screen2Sub2ViewModel(Parcel in) {
        this.beers = in.createTypedArrayList(BeerViewModel.CREATOR);
    }

    public static final Creator<Screen2Sub2ViewModel> CREATOR = new Creator<Screen2Sub2ViewModel>() {
        public Screen2Sub2ViewModel createFromParcel(Parcel source) {
            return new Screen2Sub2ViewModel(source);
        }

        public Screen2Sub2ViewModel[] newArray(int size) {
            return new Screen2Sub2ViewModel[size];
        }
    };
}
