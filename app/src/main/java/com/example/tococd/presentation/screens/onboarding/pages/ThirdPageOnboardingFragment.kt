package com.example.tococd.presentation.screens.onboarding.pages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tococd.HomeActivity
import com.example.tococd.R
import com.example.tococd.databinding.FragmentThirdPageOnboardingBinding
import com.example.tococd.presentation.screens.onboarding.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdPageOnboardingFragment : Fragment() {

    private var _binding: FragmentThirdPageOnboardingBinding? = null
    private val binding: FragmentThirdPageOnboardingBinding
        get() = _binding!!

    private val onboardingViewModel: OnboardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdPageOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startOptionThirdPageBtn.setOnClickListener {
            onboardingViewModel.saveOnboardingDisplayed()
            findNavController().navigate(R.id.action_onboardingFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}