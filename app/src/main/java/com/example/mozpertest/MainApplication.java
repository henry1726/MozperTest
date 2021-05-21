package com.example.mozpertest;

import android.app.Application;
import android.content.Context;

import com.example.mozpertest.sys.di.components.DaggerUtilComponent;
import com.example.mozpertest.sys.di.components.UtilComponent;
import com.example.mozpertest.sys.di.modules.ContextModule;
import com.example.mozpertest.sys.providers.ResourceProvider;

public class MainApplication extends Application {

    public static UtilComponent utilComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        utilComponent = DaggerUtilComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

    }

    public static Context getAppContext() {
        return utilComponent.getAppContext();
    }

    public static ResourceProvider getResourceProvider() {
        return utilComponent.getResourceProvider();
    }
}
