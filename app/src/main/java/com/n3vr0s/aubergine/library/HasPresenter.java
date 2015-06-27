package com.n3vr0s.aubergine.library;

public interface HasPresenter<P extends AuberginePresenter> {
    P getPresenter();
}
