package com.example.tococd.presentation.screens.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tococd.HomeActivity
import com.example.tococd.R
import com.example.tococd.databinding.FragmentSplashPageBinding
import com.example.tococd.utils.extension.observeFlows
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashPageFragment : Fragment() {

    private var _binding: FragmentSplashPageBinding? = null
    private val binding: FragmentSplashPageBinding
        get() = _binding!!

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animateText()
        binding.splashScreenUp.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                setUpCollectors()
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun animateText() {
        val context = requireContext()
        val bottomAnimation = AnimationUtils.loadAnimation(context, R.anim.scrolling_down)
        val headAnimation = AnimationUtils.loadAnimation(context, R.anim.scrolling_up)
        with(binding) {
            splashScreenDown.startAnimation(bottomAnimation)
            splashScreenUp.startAnimation(headAnimation)
        }
    }

    private fun goToHome() {
        Intent(requireContext(), HomeActivity::class.java).apply {
            startActivity(this)
            activity?.finish()
        }

    }

    private fun setUpCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                splashViewModel.onboardinDisplayed.collect { displayed ->
                    if (displayed) {
                        goToHome()
                    } else {
                        findNavController().navigate(R.id.action_splashPageFragment_to_onboardingFragment)
                    }
                }
            }
        }
    }
}