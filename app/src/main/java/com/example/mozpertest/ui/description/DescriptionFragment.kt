package com.example.mozpertest.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mozpertest.data.entities.EmployeesEntity
import com.example.mozpertest.databinding.DescriptionFragmentBinding

class DescriptionFragment: Fragment() {

    private lateinit var binding: DescriptionFragmentBinding
    private lateinit var description: String

    companion object {
        @JvmStatic
        fun newInstance(description: String) = DescriptionFragment().apply {
            arguments = Bundle().apply {
                putString("Description", description)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        description = arguments?.getString("Description", "").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DescriptionFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDescription.setText(description)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}