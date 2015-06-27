package com.n3vr0s.aubergine.library;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface Presenter<T> {

    void onCreate(@Nullable Bundle bundle);
    void onSaveInstanceState(@NonNull Bundle bundle);
    void onResume();
    void onPause();
    void onDestroy();
    void bindView(T view);
    void unbindView();
}
