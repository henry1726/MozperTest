package com.example.mozpertest.data.datasources.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mozpertest.data.entities.EmployeesEntity


@Dao
interface EmployeesDAO {
    @Query("SELECT * FROM employeesTable")
    fun getAllEmployees() : List<EmployeesEntity>

    @Query("SELECT description FROM employeesTable WHERE id = :id")
    fun getAllEmployeesById(id: Int) : String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(employee: List<EmployeesEntity?>?)

    @Update
    fun updateEmployee(employee: EmployeesEntity)

    @Delete
    fun deleteEmployeesList(employee: EmployeesEntity)
}