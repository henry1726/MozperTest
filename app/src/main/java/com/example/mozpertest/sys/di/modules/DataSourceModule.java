package com.example.mozpertest.sys.di.modules;

import com.example.mozpertest.data.datasources.db.EmployeesDAO;
import com.example.mozpertest.data.datasources.db.declaration.EmployeesDataBase;
import com.example.mozpertest.data.datasources.web.EmployeesWeb;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;


@Module(includes = DatabaseModule.class)
public class DataSourceModule {

    @Singleton
    @Provides
    EmployeesDAO provideEmployeesDAO(EmployeesDataBase database) {
        return database.getEmployeesDAO();
    }

    @Singleton
    @Provides
    EmployeesWeb provideEmployeesWeb() {
        return new EmployeesWeb();
    }
}