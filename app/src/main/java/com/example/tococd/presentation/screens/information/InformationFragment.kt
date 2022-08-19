package com.example.tococd.presentation.screens.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tococd.R
import com.example.tococd.databinding.FragmentInformationBinding
import com.example.tococd.utils.extension.hide
import com.example.tococd.utils.extension.observeFlows
import com.example.tococd.utils.extension.show
import com.example.tococd.utils.extension.showOnboardingDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InformationFragment : Fragment() {

    private var _binding: FragmentInformationBinding? = null
    private val binding: FragmentInformationBinding
        get() = _binding!!

    private val informationAdapter by lazy { InformationAdapter() }
    private val informationViewModel by viewModels<InformationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpCollectors()
        setUpListeners()
    }

    private fun setUpViews() {
        binding.recyclerViewInformation.apply {
            adapter = informationAdapter
            setHasFixedSize(true)
        }
    }

    private fun setUpListeners() {
        binding.moreInformationAboutFragment.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        context?.showOnboardingDialog(
            titleId = R.string.information_area_title,
            descriptionId = R.string.information_area_description,
            secondTitleId = R.string.information_area_title,
            secondDescriptionId = R.string.touch_description,
            lottieAnimationView = R.raw.welcome_information,
            secondLottieAnimationView = R.raw.touch
        )
    }

    private fun setUpCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                informationViewModel.informationList.collect {
                    informationAdapter.submitList(it)
                }
            }

            coroutineScope.launch {
                informationViewModel.informationDisplayedFirstTime.collect { displayed ->
                    if (!displayed) {
                        showDialog()
                        informationViewModel.saveDisplayedFirstTime()
                    }
                }
            }

            coroutineScope.launch {
                informationViewModel.userName.collect(::setUserName)
            }
        }
    }

    private fun setUserName(name: String) {
        with(binding) {
            if (name.isEmpty()) {
                yourNameHere.hide()
            } else {
                yourNameHere.text = getString(R.string.user_name, name)
                yourNameHere.show()
            }
        }
    }
}
