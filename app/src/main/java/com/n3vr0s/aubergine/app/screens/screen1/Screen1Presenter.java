package com.n3vr0s.aubergine.app.screens.screen1;

import com.n3vr0s.aubergine.app.events.NavigateToScreen2Event;
import com.n3vr0s.aubergine.library.AuberginePresenter;

import org.androidannotations.annotations.EBean;

import de.greenrobot.event.EventBus;

@EBean
public class Screen1Presenter extends AuberginePresenter<Screen1View, Screen1ViewModel> {

    public void buttonPressed() {
        incrementSerial();
        view.get().show("Click #" + viewModel.serial);
    }

    private void incrementSerial() {
        viewModel.serial++;
    }

    @Override public void bindView(Screen1View view) {
        super.bindView(view);
        view.show("Click #" + viewModel.serial);
        view.showInInput(viewModel.text);
    }

    @Override public void onPause() {
        viewModel.text = view.get().getInput();
    }

    @Override protected Screen1ViewModel prepareViewModel() {
        return new Screen1ViewModel();
    }

    public void buttonGoToNextScreenPressed() {
        EventBus.getDefault().post(new NavigateToScreen2Event());
    }
}