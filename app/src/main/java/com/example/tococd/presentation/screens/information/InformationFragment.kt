package com.example.tococd.presentation.screens.information

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.amrdeveloper.lottiedialog.LottieDialog
import com.example.tococd.R
import com.example.tococd.databinding.FragmentInformationBinding
import com.example.tococd.model.InformationModel


class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding

    private val informationViewModel by viewModels<InformationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val takePictureAction = Button(this.context)
        takePictureAction.setBackgroundColor(Color.LTGRAY)
        takePictureAction.text = "Continue"
        takePictureAction.setTextColor(Color.WHITE)
        takePictureAction.background = context?.resources?.getDrawable(R.drawable.blue_button)

        val lastActionInformation = Button(this.context)
        lastActionInformation.setBackgroundColor(Color.LTGRAY)
        lastActionInformation.text = ("Continue")
        lastActionInformation.setTextColor(Color.WHITE)
        lastActionInformation.background = context?.resources?.getDrawable(R.drawable.blue_button)


        val dialog = LottieDialog(this.context)
            .setAnimation(R.raw.information)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let { ContextCompat.getDrawable(it.applicationContext, R.drawable.blue_button) })
            .setTitle("Information Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("Welcome to the information area, remember that the first step to improve is to be informed, here you will know the answers to the biggest questions that arise around OCD.")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            //.setDialogBackgroundDrawable()
            .addActionButton(takePictureAction)

        val dialog2 = LottieDialog(this.context)
            .setAnimation(R.raw.touch)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let { ContextCompat.getDrawable(it.applicationContext, R.drawable.blue_button) })
            .setTitle("Information Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("Touch each card to display all the information and answer your questions.")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            //.setDialogBackgroundDrawable()
            .addActionButton(lastActionInformation)

      /*  takePictureAction.setOnClickListener {
            dialog.cancel()
            dialog2.show()
            SharedApp.prefs.information = "true"
        }

        lastActionInformation.setOnClickListener {
            dialog2.cancel()
            SharedApp.prefs.information = "true"
        }

        binding = FragmentInformationBinding.inflate(layoutInflater, container, false)

        if (SharedApp.prefs.information?.isEmpty() == true){
            dialog.show()
        }*/


       /* // Use shared preference (show)
        binding.yourNameHere.text = ("\uD83D\uDC4B Hi " + SharedApp.prefs.name)*/

        //informationViewModel.getAllInformationList()
        informationViewModel.informationList.observe(viewLifecycleOwner, Observer { value ->
            setRecyclerView(value)
        })

        var like: Boolean = false
        like =
            likeAnimation(binding.moreInformationAboutFragment as LottieAnimationView, R.raw.more_info_about_fragment, like)

        binding.moreInformationAboutFragment.setOnClickListener {
            dialog.show()
        }

        return binding.root
    }

    private fun likeAnimation(
        imageView: LottieAnimationView,
        animation: Int,
        like: Boolean
    ): Boolean {
        imageView.setAnimation(animation)
        imageView.repeatCount = LottieDrawable.INFINITE
        imageView.playAnimation()
        return !like
    }

    private fun setRecyclerView(informationList: List<InformationModel>) {
        val informationAdapter = InformationAdapter(informationList)
        binding.recyclerViewInformation.adapter = informationAdapter
        binding.recyclerViewInformation.setHasFixedSize(true)
    }

}
