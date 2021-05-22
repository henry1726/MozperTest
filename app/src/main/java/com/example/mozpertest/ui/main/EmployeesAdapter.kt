package com.example.mozpertest.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.databinding.ItemEmployeesBinding

class EmployeesAdapter(private val onEmployeeSelected: OnEmployeeSelected): RecyclerView.Adapter<EmployeesAdapter.EmployeesHolder>() {

    private val list = ArrayList<EmployeesEntity>()
    private lateinit var mContext: Context

    fun addEmployees(employees: List<EmployeesEntity>){
        list.clear()
        list.addAll(employees)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesHolder {
        val binding = ItemEmployeesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mContext = parent.context
        return EmployeesHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EmployeesHolder, position: Int) {
        holder.view.model = list[position]

        Glide.with(mContext)
            .load(list[position].image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.view.imgPhoto)
    }

    inner class EmployeesHolder(var view: ItemEmployeesBinding): RecyclerView.ViewHolder(view.root) {
        init {
            view.clEmployees.setOnClickListener {
                val employee = list[layoutPosition]
                onEmployeeSelected.onClickEmployee(employee.description)
            }
        }
    }
}