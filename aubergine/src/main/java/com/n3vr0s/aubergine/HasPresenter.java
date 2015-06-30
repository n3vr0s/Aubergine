package com.n3vr0s.aubergine;

public interface HasPresenter<P extends AuberginePresenter> {
    P getPresenter();
}
