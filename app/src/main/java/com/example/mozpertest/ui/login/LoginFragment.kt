package com.example.mozpertest.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mozpertest.databinding.LoginFragmentBinding
import com.example.mozpertest.ui.main.MainActivity

class LoginFragment: Fragment() {

    private lateinit var binding: LoginFragmentBinding

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment().apply {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabLogin.setOnClickListener{
            val intent = Intent(this@LoginFragment.activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}