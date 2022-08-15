package com.example.tococd.view.fragment

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
import com.example.tococd.databinding.FragmentTypesLayoutBinding
import com.example.tococd.model.TypesModel
import com.example.tococd.utils.Event
import com.example.tococd.utils.SharedApp
import com.example.tococd.view.adapter.InformationAdapter
import com.example.tococd.view.adapter.TypesAdapter
import com.example.tococd.viewmodel.TypesViewModel

class TypesFragment : Fragment() {

    private var _binding: FragmentTypesLayoutBinding? = null
    private val binding: FragmentTypesLayoutBinding
        get() = _binding!!
    private val typesViewModel: TypesViewModel by viewModels()
    private val typesAdapter: TypesAdapter by lazy { TypesAdapter() }

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
        val takePictureAction = Button(this.context)
        takePictureAction.setBackgroundColor(Color.LTGRAY)
        takePictureAction.setText("Continue")
        takePictureAction.setTextColor(Color.WHITE)
        takePictureAction.background = context?.resources?.getDrawable(R.drawable.blue_button)

        val lasActionTypes = Button(this.context)
        lasActionTypes.setBackgroundColor(Color.LTGRAY)
        lasActionTypes.setText("Continue")
        lasActionTypes.setTextColor(Color.WHITE)
        lasActionTypes.background = context?.resources?.getDrawable(R.drawable.blue_button)

        val dialog = LottieDialog(this.context)
            .setAnimation(R.raw.searching)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let {
                ContextCompat.getDrawable(
                    it.applicationContext,
                    R.drawable.blue_button
                )
            })
            .setTitle("Types of OCD Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("Welcome to the OCD Types area, here you will find information on the most common types of OCD")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            .addActionButton(takePictureAction)

        val dialog2 = LottieDialog(this.context)
            .setAnimation(R.raw.click_json_3)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let {
                ContextCompat.getDrawable(
                    it.applicationContext,
                    R.drawable.blue_button
                )
            })
            .setTitle("Types of OCD Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("You can also click on the blue icon on the right to see much more information on specialized websites.")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            .addActionButton(lasActionTypes)


        takePictureAction.setOnClickListener {
            dialog.cancel()
            dialog2.show()
            SharedApp.prefs.types = "true"
        }

        lasActionTypes.setOnClickListener {
            dialog2.cancel()
            SharedApp.prefs.types = "true"
        }


        if (SharedApp.prefs.types?.isEmpty() == true) {
            dialog.show()
        }

        typesViewModel.getAllTypesList()

        var like: Boolean = false
        like =
            likeAnimation(
                binding.moreInformationAboutFragment as LottieAnimationView,
                R.raw.more_info_about_fragment,
                like
            )

        binding.moreInformationAboutFragment.setOnClickListener {
            dialog.show()
        }

        setUpObservers()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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

    private fun setUpViews() {
        binding.recyclerViewTypes.apply {
            adapter = typesAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleEvent(event: Event<List<TypesModel>>?) {
        event?.getContentIfNotHandled()?.let {
            typesAdapter.setData(it)
        }
    }

    private fun setUpObservers() {
        typesViewModel.typesList.observe(viewLifecycleOwner) { event ->
            handleEvent(event)
        }
    }
}