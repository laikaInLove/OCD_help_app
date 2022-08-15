package com.example.tococd.presentation.screens.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.example.tococd.R
import com.example.tococd.databinding.FragmentInformationBinding
import com.example.tococd.utils.extension.hide
import com.example.tococd.utils.extension.observeFlows
import com.example.tococd.utils.extension.show
import com.google.android.material.button.MaterialButton
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
        val context = requireContext()
        val alertDialog = AlertDialog.Builder(context).setCancelable(false)
        val view =
            LayoutInflater.from(context).inflate(R.layout.dialog_welcome_information_screen, null)
        val customDialog = alertDialog
            .setView(view)
            .create()
        val dialogButton = view.findViewById<MaterialButton>(R.id.informationAreaBtn)
        val lottieView = view.findViewById<LottieAnimationView>(R.id.informationAreaImageLav)
        val descriptionText = view.findViewById<TextView>(R.id.informationAreaDescriptionTv)

        dialogButton.setOnClickListener {
            if (dialogButton.text.equals(getString(R.string.close_option))) {
                customDialog.dismiss()
            } else {
                lottieView.setAnimation(R.raw.touch)
                lottieView.playAnimation()
                descriptionText.text = getString(R.string.touch_description)
                dialogButton.text = getString(R.string.close_option)
            }
        }
        customDialog.show()
    }

    private fun setUpCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                informationViewModel.informationList.collect {
                    informationAdapter.submitList(it)
                }
            }

            coroutineScope.launch {
                informationViewModel.informationDisplayedFirstTime.collect {
                    if (it.isEmpty()) {
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
