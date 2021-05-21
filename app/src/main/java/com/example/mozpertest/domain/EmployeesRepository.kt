package com.example.mozpertest.domain

import android.content.Context
import androidx.lifecycle.Observer
import com.example.mozpertest.data.datasources.db.EmployeesDAO
import com.example.mozpertest.data.datasources.web.EmployeesWeb
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.sys.di.components.DaggerDataSourceComponent
import com.example.mozpertest.sys.di.modules.ContextModule
import com.example.mozpertest.ui.MainApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Suppress("INACCESSIBLE_TYPE")
class EmployeesRepository(){

    @Inject
    lateinit var webDS: EmployeesWeb
    @Inject
    lateinit var diskDS: EmployeesDAO


    init {
        DaggerDataSourceComponent.builder()
            .contextModule(ContextModule(MainApplication.getAppContext()))
            .build().inject(this)
    }

    fun getAllEmployees(observer: Observer<List<EmployeesEntity>>){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                observer.onChanged(diskDS.getAllEmployees())
            }
        }
    }

    fun getAllEmployeesById(observer: Observer<String>, id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                observer.onChanged(diskDS.getAllEmployeesById(id))
            }
        }
    }

    fun getEmployees(){
        webDS.downloadEmployees(buildObserver())
    }

    private fun buildObserver(): Observer<List<EmployeesEntity>>{
        return Observer {
            if (it.isNotEmpty()){
                diskDS.insertAll(it)
            }
        }
    }
}