package com.example.mozpertest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.databinding.ItemEmployeesBinding

class EmployeesAdapter(private val viewModel: HomeViewModel): RecyclerView.Adapter<EmployeesAdapter.EmployeesHolder>() {

    private val list = ArrayList<EmployeesEntity>()

    fun addEmployees(dimaAccounts: List<EmployeesEntity>){
        list.clear()
        list.addAll(dimaAccounts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesHolder {
        val binding = ItemEmployeesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeesHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EmployeesHolder, position: Int) {
        holder.view.model = list[position]
    }

    inner class EmployeesHolder(var view: ItemEmployeesBinding): RecyclerView.ViewHolder(view.root) {
        init {
            view.clEmployees.setOnClickListener {
                val employee = list[layoutPosition]
                viewModel.actionClickCard(employee.id)
            }
        }
    }
}