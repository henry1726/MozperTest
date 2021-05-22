package com.example.mozpertest.data.datasources.web.reponses

import com.example.mozpertest.data.entities.EmployeesEntity
import com.google.gson.annotations.SerializedName

data class EmployeesResponse(
    @SerializedName("employees") val employees : List<EmployeesEntity>

)
