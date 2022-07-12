package com.example.gads_lp1dd_anac_mb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.gads_lp1dd_anac_mb.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.buttonLogin.setOnClickListener {
//            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_loginFragment) }
//            Toast.makeText(activity, "YOU CLICKED CANCEL BVV", Toast.LENGTH_SHORT).show()
            // DON'T USE TOP METHOD IT'S NOT COMPILE TIME SAFE

            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }



        return binding.root
    }

}

