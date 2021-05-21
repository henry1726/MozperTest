package com.example.mozpertest.sys.di.modules;

import android.content.Context;

import androidx.room.Room;

import com.example.mozpertest.data.datasources.db.declaration.EmployeesDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class DatabaseModule {
    @Singleton
    @Provides
    EmployeesDataBase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, EmployeesDataBase.class, "Employees_db")
                .allowMainThreadQueries()
                .build();
    }
}
