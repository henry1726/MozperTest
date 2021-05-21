package com.example.mozpertest.sys.di.components;


import com.example.mozpertest.sys.di.modules.DataSourceModule;
import com.example.mozpertest.domain.EmployeesRepository;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DataSourceModule.class)
public interface DataSourceComponent {

    void inject(EmployeesRepository repository);

}