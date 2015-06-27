package com.n3vr0s.aubergine.test;

import com.n3vr0s.aubergine.app.screens.screen2.sub1.Screen2Sub1Presenter;
import com.n3vr0s.aubergine.app.screens.screen2.sub1.Screen2Sub1RelativeLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Screen2Sub1PresenterTest {

    @Mock Screen2Sub1RelativeLayout view;

    private Screen2Sub1Presenter presenter;

    @Before public void setUp(){
        presenter = new Screen2Sub1Presenter();
        presenter.onCreate(null);
        presenter.bindView(view);
    }

    @Test public void updateViewModel(){
        presenter.updateViewModel(3,5);
        assertEquals(presenter.getViewModel().addentA, 3);
        assertEquals(presenter.getViewModel().addentB, 5);
    }

}
