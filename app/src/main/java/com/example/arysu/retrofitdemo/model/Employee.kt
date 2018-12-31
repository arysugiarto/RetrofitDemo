package com.example.arysu.retrofitdemo.model

import com.google.gson.annotations.SerializedName

class Employee(@field:SerializedName("name")
               var name: String?, @field:SerializedName("email")
               var email: String?, @field:SerializedName("phone")
               var phone: String?)
