package com.example.gads_lp1dd_anac_mb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gads_lp1dd_anac_mb.databinding.FragmentHomeBinding
import com.example.gads_lp1dd_anac_mb.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        val userNameDeepLink = args.username
        binding.username.setText(userNameDeepLink)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()


            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username = username,password = password)
            findNavController().navigate(action)
        }



        return binding.root
    }

}