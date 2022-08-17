package com.example.tococd.presentation.screens.onboarding.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tococd.R
import com.example.tococd.databinding.FragmentFirstPageOnboardingBinding

class FirstPageOnboardingFragment : Fragment() {

    private var _binding: FragmentFirstPageOnboardingBinding? = null
    private val binding: FragmentFirstPageOnboardingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstPageOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.onboardingVp)
        binding.nextOptionFirstPageBtn.setOnClickListener {
            viewPager?.currentItem = 1
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}