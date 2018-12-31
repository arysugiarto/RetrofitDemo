package com.example.arysu.retrofitdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.Toast

import com.example.arysu.retrofitdemo.R
import com.example.arysu.retrofitdemo.adapter.EmployeeAdapter
import com.example.arysu.retrofitdemo.model.Employee
import com.example.arysu.retrofitdemo.model.EmployeeList
import com.example.arysu.retrofitdemo.network.GetEmployeeDataService
import com.example.arysu.retrofitdemo.network.RetrofitInstance

import java.util.ArrayList

import retrofit2.Callback
import retrofit2.Response

//arysugiarto

class MainActivity : AppCompatActivity() {

    private var adapter: EmployeeAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Create handle for the RetrofitInstance interface*/
        val service = RetrofitInstance.getRetrofitInstance().create<GetEmployeeDataService>(GetEmployeeDataService::class.java!!)

        /*Call the method with parameter in the interface to get the employee data*/
        val call = service.getEmployeeData(100)

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url().toString() + "")

        call.enqueue(object : Callback<EmployeeList> {
            override fun onResponse(call: retrofit2.Call<EmployeeList>, response: Response<EmployeeList>) {
                generateEmployeeList(response.body().employeeArrayList!!)
            }

            override fun onFailure(call: retrofit2.Call<EmployeeList>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private fun generateEmployeeList(empDataList: ArrayList<Employee>) {
        recyclerView = findViewById<View>(R.id.recycler_view_employee_list) as RecyclerView?

        adapter = EmployeeAdapter(empDataList)

        val layoutManager = LinearLayoutManager(this@MainActivity)

        recyclerView!!.layoutManager = layoutManager

        recyclerView!!.adapter = adapter
    }
}

