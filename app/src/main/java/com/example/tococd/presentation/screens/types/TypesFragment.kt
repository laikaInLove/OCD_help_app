package com.example.tococd.presentation.screens.types

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.tococd.R
import com.example.tococd.databinding.FragmentTypesLayoutBinding
import com.example.tococd.utils.extension.initUrl
import com.example.tococd.utils.extension.observeFlows
import com.example.tococd.utils.extension.showOnboardingDialog
import kotlinx.coroutines.launch

class TypesFragment : Fragment() {

    private var _binding: FragmentTypesLayoutBinding? = null
    private val binding: FragmentTypesLayoutBinding
        get() = _binding!!
    private val typesViewModel: TypesViewModel by viewModels()
    private val typesAdapter: TypesAdapter by lazy { TypesAdapter(::handleUrl) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTypesLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpCollectors()
        setUpListeners()
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
            titleId = R.string.types_dialog_title,
            descriptionId = R.string.types_dialog_description,
            secondTitleId = R.string.types_dialog_title,
            secondDescriptionId = R.string.psychologitst_dialog_second_description,
            lottieAnimationView = R.raw.searching,
            secondLottieAnimationView = R.raw.click_json_3
        )
    }

    private fun setUpViews() {
        binding.recyclerViewTypes.apply {
            adapter = typesAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleUrl(url: String) {
        activity?.initUrl(url)
    }

    private fun setUpCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                typesViewModel.typesList.collect { typesState ->
                    typesAdapter.submitList(typesState.types)
                }
            }
        }
    }
}