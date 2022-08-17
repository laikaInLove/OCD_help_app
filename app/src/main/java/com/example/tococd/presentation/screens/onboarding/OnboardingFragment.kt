package com.example.tococd.presentation.screens.onboarding

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tococd.databinding.FragmentOnboardingBinding
import com.example.tococd.presentation.screens.onboarding.pages.FirstPageOnboardingFragment
import com.example.tococd.presentation.screens.onboarding.pages.SecondPageOnboardingFragment
import com.example.tococd.presentation.screens.onboarding.pages.ThirdPageOnboardingFragment
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3


@AndroidEntryPoint
class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding: FragmentOnboardingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root

        val indicator: CircleIndicator3 = binding.indicator
        indicator.setViewPager(binding.onboardingVp)
        indicator.createIndicators(2,0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setUpViewPager() {
        val fragments = arrayListOf<Fragment>(
            FirstPageOnboardingFragment(),
            SecondPageOnboardingFragment(),
            ThirdPageOnboardingFragment()
        )
        val adapter = OnBoardingAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.onboardingVp.adapter = adapter
    }
}