package com.example.mozpertest.sys.di.modules;

import android.content.Context;

import com.example.mozpertest.sys.providers.ResourceProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class UtilModule {

    @Provides
    @Singleton
    public ResourceProvider provideResourceProvider(Context context) {
        return new ResourceProvider(context);
    }
}
