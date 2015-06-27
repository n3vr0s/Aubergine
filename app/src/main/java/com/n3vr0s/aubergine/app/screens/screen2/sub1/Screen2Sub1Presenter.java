package com.n3vr0s.aubergine.app.screens.screen2.sub1;

import com.n3vr0s.aubergine.app.events.NavigateToScreen2Sub2Event;
import com.n3vr0s.aubergine.library.AuberginePresenter;

import org.androidannotations.annotations.EBean;

import de.greenrobot.event.EventBus;

@EBean
public class Screen2Sub1Presenter extends AuberginePresenter<Screen2Sub1View, Screen2Sub1ViewModel> {

    @Override public void onResume() {
        super.onResume();
        if(isViewAttached()){
            calculate(viewModel.addentA, viewModel.addentB);
        }
    }

    @Override public void onPause() {
        if(isViewAttached()){
            updateViewModel(view.get().getAddendA(), view.get().getAddendB());
        }
    }

    public void updateViewModel(int addendA, int addendB) {
        viewModel.addentA = addendA;
        viewModel.addentB = addendB;
    }

    @Override protected Screen2Sub1ViewModel prepareViewModel() {
        return new Screen2Sub1ViewModel();
    }

    public void calculate(int addendA, int addendB) {
        updateViewModel(addendA, addendB);
        int sum = addendA + addendB;
        view.get().showCalculationResult(sum);
    }

    public void buttonGoToNextScreenPressed() {
        EventBus.getDefault().post(new NavigateToScreen2Sub2Event());
    }
}