package com.example.mozpertest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.databinding.HomeFragmentBinding
import com.example.mozpertest.sys.di.modules.ViewModelModule

class HomeFragment: Fragment()  {

    private lateinit var binding: HomeFragmentBinding
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: EmployeesAdapter
    lateinit var mList: List<EmployeesEntity>
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        activity?.application?.let{
            viewModel = ViewModelProvider(this, ViewModelModule(it)).get(HomeViewModel::class.java)
            adapter = EmployeesAdapter(viewModel)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getAllEmployees(onGetEmployyes())

    }

    private fun onGetEmployyes(): Observer<List<EmployeesEntity>> {
        return Observer {
            Log.e("Dima","Size " + it.size)
            adapter.addEmployees(it)
            mList = it;
        }
    }

    private fun onActionCardClick(): Observer<Int> {
        return Observer {
            viewModel.getAllEmployeesById(onGetDescriptionEmployee(), it)
        }
    }

    fun onGetDescriptionEmployee(): Observer<String>{
        return Observer {
           Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun observeStreams(){
        viewModel.onActionCardClick.observe(viewLifecycleOwner, onActionCardClick())
    }
}