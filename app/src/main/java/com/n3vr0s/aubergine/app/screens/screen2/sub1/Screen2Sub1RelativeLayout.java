package com.n3vr0s.aubergine.app.screens.screen2.sub1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.n3vr0s.aubergine.app.R;
import com.n3vr0s.aubergine.app.utils.NumberUtils;
import com.n3vr0s.aubergine.AuberginePresenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.fragment_screen2_sub1)
public class Screen2Sub1RelativeLayout extends RelativeLayout implements Screen2Sub1View {

    @Bean Screen2Sub1Presenter presenter;

    @ViewById(R.id.etAddendA) EditText etAddendA;
    @ViewById(R.id.etAddendB) EditText etAddendB;
    @ViewById(R.id.tvSum) TextView tvSum;
    @ViewById(R.id.btnCalculate) Button btnCalculate;

    public Screen2Sub1RelativeLayout(Context context) {
        super(context);
    }

    public Screen2Sub1RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public int getAddendA() {
        return NumberUtils.getIntFromString(etAddendA.getText().toString());
    }

    @Override public int getAddendB() {
        return NumberUtils.getIntFromString(etAddendB.getText().toString());
    }

    @Override public void showCalculationResult(int sum) {
        tvSum.setText("" + sum);
    }

    @Click(R.id.btnCalculate) public void onClickBtnCalculate(){
        presenter.calculate(getAddendA(), getAddendB());
    }

    @Click(R.id.btnNextScreen) public void buttonNextPressed() {
        presenter.buttonGoToNextScreenPressed();
    }

    @Override public AuberginePresenter getPresenter() {
        return presenter;
    }
}
