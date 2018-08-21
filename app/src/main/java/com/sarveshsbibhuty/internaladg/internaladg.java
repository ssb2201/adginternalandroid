package com.sarveshsbibhuty.internaladg;


import android.app.Application;

import com.firebase.client.Firebase;


public class internaladg extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
