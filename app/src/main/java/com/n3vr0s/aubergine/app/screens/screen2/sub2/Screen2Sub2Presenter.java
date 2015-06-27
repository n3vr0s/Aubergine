package com.n3vr0s.aubergine.app.screens.screen2.sub2;

import com.n3vr0s.aubergine.app.communications.CommunicationService;
import com.n3vr0s.aubergine.library.AuberginePresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import rx.Observable;

@EBean
public class Screen2Sub2Presenter extends AuberginePresenter<Screen2Sub2View, Screen2Sub2ViewModel> {

    @Bean
    protected CommunicationService commService;

    @Override public void onResume() {
        super.onResume();
        if(isViewAttached()){
            if(viewModel.beers.size() > 0){
                view.get().displayBeers(viewModel.beers);
            }

            commService.getIpaBeers()
                .map(beerResponse -> beerResponse.data)
                .flatMap(Observable::from)
                .map(Screen2Sub2ViewModel::transform)
                .toList()
                .doOnNext(beers ->
                        {
                            viewModel.beers = (ArrayList<Screen2Sub2ViewModel.BeerViewModel>) beers;
                            view.get().displayBeers(beers);
                        })
                .doOnError(Throwable::printStackTrace)
                .subscribe();
        }
    }

    @Override protected Screen2Sub2ViewModel prepareViewModel() {
        return new Screen2Sub2ViewModel();
    }

}