package com.example.mozpertest.sys.di.components;

import android.content.Context;

import com.example.mozpertest.sys.di.modules.UtilModule;
import com.example.mozpertest.sys.providers.ResourceProvider;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = UtilModule.class)
public interface UtilComponent {

    Context getAppContext();

    ResourceProvider getResourceProvider();
}
