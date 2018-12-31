package com.example.arysu.retrofitdemo.model

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class EmployeeList {
    @SerializedName("employeeList")
    var employeeArrayList: ArrayList<Employee>? = null
}
