package com.example.tococd.presentation.screens.onboarding.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tococd.R
import com.example.tococd.databinding.FragmentSecondPageOnboardingBinding

class SecondPageOnboardingFragment : Fragment() {

    private var _binding: FragmentSecondPageOnboardingBinding? = null
    private val binding: FragmentSecondPageOnboardingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondPageOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.onboardingVp)
        binding.nextOptionSecondPageBtn.setOnClickListener {
            viewPager?.currentItem = 2
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}