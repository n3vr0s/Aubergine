package com.n3vr0s.aubergine.app.communications;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.n3vr0s.aubergine.app.communications.responses.BeerResponse;
import com.n3vr0s.aubergine.app.utils.Const;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

@EBean(scope = Scope.Singleton)
public class CommunicationService {

    private ApiInterface apiInterface;
    private Gson gson;
    private RestAdapter restAdapter;

    @AfterInject
    protected void afterInjectCommunicationService(){

		gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            //.registerTypeAdapter(Date.class, new DateDeserializer())
            .create();

        configureRestAdapter();
	}

    public void configureRestAdapter(){

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
                request.addHeader("Connection", "Close");
                request.addQueryParam("key", Const.API_KEY);
            }
        };

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Const.webserviceUrl)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                ;

        restAdapter = builder.build();

        this.apiInterface = restAdapter.create(ApiInterface.class);
    }


    public Observable<BeerResponse> getIpaBeers(){
        return apiInterface.getBeers("30");
    }
}


