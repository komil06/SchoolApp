package com.example.schoolapp

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.schoolapp.databinding.FragmentTeacherHomeBinding



class TeacherHomeFragment : Fragment() {


    lateinit var result :String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTeacherHomeBinding.inflate(inflater,container,false)
        var options = arrayOf("10-04", "10-01","10-02","10-03","10-05")
        binding.spinner.adapter = ArrayAdapter<String>(requireContext(),
            R.layout.simple_list_item_1,options)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                result = "Please Select an Option"
            }

        }


        return binding.root
    }


}