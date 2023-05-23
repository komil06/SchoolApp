package com.example.schoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.schoolapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
     lateinit var result :String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        var options = arrayOf("Teacher", "Student")
        binding.spinner.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,options)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result = options[p2]

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                result = "Please Select an Option"
            }

        }
        binding.loginButton.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_teacherHomeFragment)

        }
        return binding.root
    }


}