package com.example.mozpertest.data.datasources.web.api

import com.example.mozpertest.data.datasources.web.reponses.EmployeesResponse
import retrofit2.Call
import retrofit2.http.GET


interface WebService {

    /**
     * Check if user is able to send data
     *
     * @return status
     */
    @GET("https://demo3535907.mockable.io/")
    fun getEmployees(): Call<EmployeesResponse>
}