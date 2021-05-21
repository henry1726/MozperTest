package com.example.mozpertest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.domain.EmployeesRepository
import com.example.mozpertest.sys.di.components.DaggerRepositoryComponent
import javax.inject.Inject

class HomeViewModel: ViewModel() {

    @Inject
    lateinit var repository: EmployeesRepository

    val onActionCardClick = MutableLiveData<Int>();

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

    fun actionClickCard(id: Int){
        onActionCardClick.postValue(id)
    }
}