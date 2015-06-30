package com.n3vr0s.aubergine.app.screens.screen1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.n3vr0s.aubergine.app.R;
import com.n3vr0s.aubergine.app.Navigator;
import com.n3vr0s.aubergine.AuberginePresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.activity_screen1)
public class Screen1RelativeLayout extends RelativeLayout implements Screen1View {

    @Bean Screen1Presenter presenter;

    @ViewById TextView tvCounter;
    @ViewById(R.id.etSample) EditText etSample;

    public Screen1RelativeLayout(Context context) {
        super(context);
    }

    public Screen1RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public void show(CharSequence stuff) {
        tvCounter.setText(stuff);
    }

    @Override public void goToNextScreen() {
        Navigator.goToScreen2(getContext());
    }

    @Override public void showInInput(CharSequence input) {
        etSample.setText(input);
    }

    @Override public String getInput() {
        return etSample.getText().toString();
    }

    @Click(R.id.btnIncrement) public void buttonIncrementPressed() {
        presenter.buttonPressed();
    }
    @Click(R.id.btnNextScreen) public void buttonNextPressed() {
        presenter.buttonGoToNextScreenPressed();
    }

    @Override public AuberginePresenter getPresenter() {
        return presenter;
    }
}
