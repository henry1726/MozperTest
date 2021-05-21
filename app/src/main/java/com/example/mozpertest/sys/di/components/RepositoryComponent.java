package com.example.mozpertest.sys.di.components;

import com.example.mozpertest.sys.di.modules.RepositoryModule;
import com.example.mozpertest.ui.main.HomeViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class)
public interface RepositoryComponent {

    void inject(HomeViewModel viewModel);
}
