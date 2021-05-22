package com.example.mozpertest.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mozpertest.databinding.LoginFragmentBinding
import com.example.mozpertest.sys.di.modules.ViewModelModule
import com.example.mozpertest.ui.main.EmployeesAdapter
import com.example.mozpertest.ui.main.HomeFragment
import com.example.mozpertest.ui.main.HomeViewModel
import com.example.mozpertest.ui.main.MainActivity

class LoginFragment: Fragment() {

    private lateinit var binding: LoginFragmentBinding
    lateinit var viewModel: LoginViewModel

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment().apply {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.application?.let{
            viewModel = ViewModelProvider(this, ViewModelModule(it)).get(LoginViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)

        viewModel.hasLoggedUser()
        viewModel.hasLoggedUser.observe(viewLifecycleOwner, {
            if(it) {
                val intent = Intent(this@LoginFragment.activity, MainActivity::class.java)
                startActivity(intent)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabLogin.setOnClickListener{
            viewModel.logginUser()
        }

        viewModel.logginUser.observe(viewLifecycleOwner, {
            if(it){
                val intent = Intent(this@LoginFragment.activity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}