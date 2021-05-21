package com.example.mozpertest.data.datasources.web

import android.util.Log
import androidx.lifecycle.Observer
import com.example.mozpertest.data.datasources.web.api.WebService
import com.example.mozpertest.data.datasources.web.reponses.EmployeesResponse
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.sys.di.components.DaggerFrameworkComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EmployeesWeb {
    @Inject
    lateinit var webService: WebService

    init {
    }

    fun downloadEmployees(observer: Observer<List<EmployeesEntity>>){
        webService.getEmployees().enqueue(object : Callback<EmployeesResponse>{
            override fun onResponse(
                call: Call<EmployeesResponse>,
                response: Response<EmployeesResponse>
            ) {
                val mBody = response.body()
                when(response.code()){
                    200 -> {
                       observer.onChanged(mBody?.employees)
                    }
                    else -> Log.e("descargaFail", response.message())
                }
            }

            override fun onFailure(call: Call<EmployeesResponse>, t: Throwable) {
                Log.e("descargaFail", "Failure")
            }

        })
    }
}