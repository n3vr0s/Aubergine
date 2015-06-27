package com.n3vr0s.aubergine.app.communications;

import com.n3vr0s.aubergine.app.communications.responses.BeerResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface ApiInterface {

    @GET("/v2/beers") Observable<BeerResponse> getBeers(@Query("styleId") String styleId);
}
