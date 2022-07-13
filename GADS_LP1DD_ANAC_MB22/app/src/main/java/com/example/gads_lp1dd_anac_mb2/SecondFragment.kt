package com.example.gads_lp1dd_anac_mb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gads_lp1dd_anac_mb2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
     val args: SecondFragmentArgs by navArgs()


            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)

                val newNumber = args.number

                binding.tv2.setText(newNumber.toString())

                binding.tv2.setOnClickListener {
                    val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
                    findNavController().navigate(action)
                }



        return binding.root

    }

}