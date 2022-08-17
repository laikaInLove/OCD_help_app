package com.example.tococd.presentation.screens.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tococd.HomeActivity
import com.example.tococd.R
import com.example.tococd.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding
        get() = _binding!!

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setUpListeners() {
        with(binding) {
            buttonName.setOnClickListener {
                if (nameTie.text?.isEmpty() == true) {
                    MotionToast.darkColorToast(
                        requireActivity(),
                        getString(R.string.invalid_name),
                        getString(R.string.invalid_name_length),
                        MotionToastStyle.WARNING,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(requireContext(), R.font.helvetica)
                    )
                } else {
                    registerViewModel.setUserName(nameTie.text.toString())
                    goToHome()
                }
            }
        }
    }

    private fun goToHome() {
        Intent(requireContext(), HomeActivity::class.java).apply {
            startActivity(this)
            activity?.finish()
        }
    }
}