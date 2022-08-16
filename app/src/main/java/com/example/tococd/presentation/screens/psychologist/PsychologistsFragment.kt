package com.example.tococd.presentation.screens.psychologist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tococd.R
import com.example.tococd.databinding.FragmentPsychologistsBinding
import com.example.tococd.presentation.screens.psychologist.state.Effect
import com.example.tococd.presentation.screens.psychologist.state.PsychologistUiState
import com.example.tococd.utils.extension.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PsychologistsFragment : Fragment() {

    private var _binding: FragmentPsychologistsBinding? = null
    private val binding: FragmentPsychologistsBinding
        get() = _binding!!

    private val psychologistViewModel: PsychologistViewModel by viewModels()
    private val psychologistsAdapter: PsychologistsAdapter by lazy { PsychologistsAdapter(::handleUrl) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPsychologistsBinding.inflate(layoutInflater, container, false)
        psychologistViewModel.getPsychologists()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        psychologistViewModel.getPsychologists()
        setUpViews()
        setUpListeners()
        setUpCollectors()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setUpListeners() {
        binding.moreInformationAboutFragment.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        context?.showOnboardingDialog(
            titleId = R.string.psychologist_title,
            descriptionId = R.string.psychologist_dialog_description,
            secondTitleId = R.string.psychologist_title,
            secondDescriptionId = R.string.psychologitst_dialog_description,
            lottieAnimationView = R.raw.help_psychologists,
            secondLottieAnimationView = R.raw.psychologists
        )
    }

    private fun setUpViews() {
        binding.psychologistRecycler.apply {
            adapter = psychologistsAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleUrl(url: String) {
        activity?.initUrl(url)
    }

    private fun setUpCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                psychologistViewModel.effect.collect {
                    when (it) {
                        is Effect.IsLoading -> handleLoading(it.loading)
                        is Effect.ShowSnackBar -> {}
                    }
                }
            }

            coroutineScope.launch {
                psychologistViewModel.psychologistUiState.collect(::handlePsychologistState)
            }
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        with(binding) {
            if (isLoading) {
                psychologistLoadingShimmerContainer.show()
                psychologistLoadingShimmerContainer.bringToFront()
            } else {
                psychologistLoadingShimmerContainer.hide()
            }
        }
    }

    private fun handlePsychologistState(state: PsychologistUiState) {
        state.data?.let {
            binding.psychologistContentGroup.show()
            psychologistsAdapter.submitList(state.data)
        }
        if (state.hasError) {
            binding.psychologistContentGroup.hide()
            binding.viewErrorPsychologist.root.show()
            activity?.showMotionToastError(
                R.string.error_title,
                R.string.unexpected_error
            )
        } else {
            binding.viewErrorPsychologist.root.hide()
        }
    }
}
