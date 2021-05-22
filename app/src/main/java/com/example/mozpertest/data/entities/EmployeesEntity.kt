package com.example.mozpertest.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "employeesTable")
data class EmployeesEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    var firstName: String,
    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    var lastName: String,
    @ColumnInfo(name = "image")
    @SerializedName("image")
    var image: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String,
    @ColumnInfo(name = "rating")
    @SerializedName("rating") var rating: Double
    )
