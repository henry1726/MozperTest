package com.example.mozpertest.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mozpertest.R
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.databinding.HomeFragmentBinding
import com.example.mozpertest.sys.di.modules.ViewModelModule
import com.example.mozpertest.ui.description.DescriptionFragment
import com.example.mozpertest.ui.login.LoginMainActivity

class HomeFragment: Fragment(), OnEmployeeSelected {

    private lateinit var binding: HomeFragmentBinding
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: EmployeesAdapter
    lateinit var mList: List<EmployeesEntity>
    private val TAG = HomeFragment::class.java.simpleName


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        activity?.application?.let{
            viewModel = ViewModelProvider(this, ViewModelModule(it)).get(HomeViewModel::class.java)
            adapter = EmployeesAdapter(this)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener{
          viewModel.hasUserLogOut()
        }

        viewModel.hasUserLogOut.observe(viewLifecycleOwner, {
            if(it){
                val intent = Intent(context, LoginMainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.downloadEmployees()
        viewModel.getAllEmployees(onGetEmployyes())
    }

    private fun onGetEmployyes(): Observer<List<EmployeesEntity>> {
        return Observer {
            adapter.addEmployees(it)
            Log.e("Employees","Size " + it.size)
            mList = it;
        }
    }

    override fun onClickEmployee(description: String) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_activity_content, DescriptionFragment.newInstance(description))
            .addToBackStack(TAG)
            .commit()
    }
}