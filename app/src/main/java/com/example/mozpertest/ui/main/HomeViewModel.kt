package com.example.mozpertest.ui.main

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.domain.EmployeesRepository
import com.example.mozpertest.sys.di.components.DaggerRepositoryComponent
import javax.inject.Inject

class HomeViewModel (private val c: Context): ViewModel() {

    @Inject
    lateinit var repository: EmployeesRepository

    val hasUserLogOut by lazy { MutableLiveData<Boolean>() }

    init {
        DaggerRepositoryComponent.create().inject(this)
    }

    fun getAllEmployees(observer: Observer<List<EmployeesEntity>>){
        repository.getAllEmployees(observer)
    }

    fun getAllEmployeesById(observer: Observer<String>, id: Int){
        repository.getAllEmployeesById(observer, id)
    }

    fun downloadEmployees(){
        repository.getEmployees()
    }

    fun hasUserLogOut(){
        hasUserLogOut.value = hasLogOutUser()
    }

    private fun hasLogOutUser(): Boolean{
        val sp = c.getSharedPreferences("SP_USER", Context.MODE_PRIVATE)
        return sp.edit().clear().commit()
    }
}