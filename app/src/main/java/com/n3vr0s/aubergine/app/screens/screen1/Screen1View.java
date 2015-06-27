package com.n3vr0s.aubergine.app.screens.screen1;

import com.n3vr0s.aubergine.library.AubergineView;

public interface Screen1View extends AubergineView {
    void show(CharSequence stuff);
    void goToNextScreen();
    void showInInput(CharSequence input);
    String getInput();
}
