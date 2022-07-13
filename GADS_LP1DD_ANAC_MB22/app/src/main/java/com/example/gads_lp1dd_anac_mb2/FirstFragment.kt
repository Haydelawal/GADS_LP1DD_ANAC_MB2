package com.example.gads_lp1dd_anac_mb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gads_lp1dd_anac_mb2.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.tv1.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(333)
            findNavController().navigate(action)
        }



        return binding.root
    }

}