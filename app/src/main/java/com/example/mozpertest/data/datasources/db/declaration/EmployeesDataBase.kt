package com.example.mozpertest.data.datasources.db.declaration

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mozpertest.data.datasources.db.EmployeesDAO
import com.example.mozpertest.data.entities.EmployeesEntity

@Database(entities = [EmployeesEntity::class], version = 2)
abstract class EmployeesDataBase : RoomDatabase() {
    abstract fun getEmployeesDAO(): EmployeesDAO
}