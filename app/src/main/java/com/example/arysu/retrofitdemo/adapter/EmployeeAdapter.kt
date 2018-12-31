package com.example.arysu.retrofitdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.arysu.retrofitdemo.R
import com.example.arysu.retrofitdemo.model.Employee

import java.util.ArrayList

class EmployeeAdapter(private val dataList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.txtEmpName.text = dataList[position].name
        holder.txtEmpEmail.text = dataList[position].email
        holder.txtEmpPhone.text = dataList[position].phone
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtEmpName: TextView
        var txtEmpEmail: TextView
        var txtEmpPhone: TextView

        init {
            txtEmpName = itemView.findViewById(R.id.txt_employee_name)
            txtEmpEmail = itemView.findViewById(R.id.txt_employee_email)
            txtEmpPhone = itemView.findViewById(R.id.txt_employee_phone)
        }
    }
}
