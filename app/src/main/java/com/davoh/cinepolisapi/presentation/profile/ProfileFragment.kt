package com.davoh.cinepolisapi.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.databinding.FragmentProfileBinding
import com.davoh.cinepolisapi.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment() {
    
    private val viewModel:ProfileViewModel by viewModels()
    private lateinit var binding : FragmentProfileBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        
        configToolbar(binding.toolbarInclude.toolbar)
        titleFragment(getString(R.string.perfil), binding.toolbarInclude.toolbarTitle)
        
        
        observables()
        
        
        return binding.root
    }
    
    private fun observables(){
        viewModel.getProfile()
        viewModel.profileData.observe(viewLifecycleOwner,{ profileData->
            
            binding.tvUsername.text = profileData.firstName + " " + profileData.lastName
            binding.tvEmail.text = profileData.email
            binding.tvCard.text = profileData.cardNumber
            
        })
    }
    
}