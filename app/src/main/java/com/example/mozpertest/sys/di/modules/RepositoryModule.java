package com.example.mozpertest.sys.di.modules;

import com.example.mozpertest.domain.EmployeesRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;




@Module
public class RepositoryModule {

    @Singleton
    @Provides
    EmployeesRepository provideEmployeesRepository(){ return new EmployeesRepository(); }
}