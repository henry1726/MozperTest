package com.example.mozpertest.sys.di.components;

import com.example.mozpertest.data.datasources.web.EmployeesWeb;
import com.example.mozpertest.sys.di.modules.NetworkModule;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = NetworkModule.class)
public interface FrameworkComponent {

    void inject(EmployeesWeb employeesWeb);
}