package com.n3vr0s.aubergine.app.screens.screen2.sub1;

import com.n3vr0s.aubergine.AubergineView;

public interface Screen2Sub1View extends AubergineView {

    int getAddendA();
    int getAddendB();

    void showCalculationResult(int sum);
}
