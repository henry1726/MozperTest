package com.example.mozpertest.data.datasources.web

import android.util.Log
import androidx.lifecycle.Observer
import com.example.mozpertest.MainApplication
import com.example.mozpertest.data.datasources.web.api.WebService
import com.example.mozpertest.data.datasources.web.reponses.EmployeesResponse
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.sys.di.components.DaggerFrameworkComponent
import com.example.mozpertest.sys.di.modules.ContextModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EmployeesWeb {
    @Inject
    lateinit var webService: WebService

    init {
        DaggerFrameworkComponent.builder()
            .build()
            .inject(this)
    }

    fun downloadEmployees(observer: Observer<List<EmployeesEntity>>){
        webService.getEmployees().enqueue(object : Callback<EmployeesResponse>{
            override fun onResponse(
                call: Call<EmployeesResponse>,
                response: Response<EmployeesResponse>
            ) {
                when(response.code()){
                    200 -> {
                        response.body()?.let {
                            observer.onChanged(it.employees)
                            Log.i("Download", "Gone")
                        }

                    }
                    400 -> Log.e("descargaFail-2: ", response.message() +" "+ response.code())
                }
            }

            override fun onFailure(call: Call<EmployeesResponse>, t: Throwable) {
                Log.e("descargaFail", t.localizedMessage)
            }

        })
    }
}