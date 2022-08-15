package com.example.tococd.presentation.screens.psychologist

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.amrdeveloper.lottiedialog.LottieDialog
import com.example.tococd.R
import com.example.tococd.databinding.FragmentPsychologistsBinding
import com.example.tococd.data.remote.response.PsychologistsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PsychologistsFragment : Fragment() {

    private lateinit var binding: FragmentPsychologistsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val takePictureAction = Button(this.context)
        takePictureAction.setBackgroundColor(Color.LTGRAY)
        takePictureAction.setText("Continue")
        takePictureAction.setTextColor(Color.WHITE)
        takePictureAction.background = context?.resources?.getDrawable(R.drawable.blue_button)

        val lastAction = Button(this.context)
        lastAction.setBackgroundColor(Color.LTGRAY)
        lastAction.setText("Continue")
        lastAction.setTextColor(Color.WHITE)
        lastAction.background = context?.resources?.getDrawable(R.drawable.blue_button)

        val dialog = LottieDialog(this.context)
            .setAnimation(R.raw.help_psychologists)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let { ContextCompat.getDrawable(it.applicationContext, R.drawable.blue_button) })
            .setTitle("Seek help Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("Welcome to the help area, here you will find a list of OCD professionals who will be able to advise and help you.")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            //.setDialogBackgroundDrawable()
            .addActionButton(takePictureAction)

        val dialog2 = LottieDialog(this.context)
            .setAnimation(R.raw.psychologists)
            .setAnimationRepeatCount(LottieDrawable.INFINITE)
            .setAutoPlayAnimation(true)
            .setDialogBackgroundDrawable(context?.let { ContextCompat.getDrawable(it.applicationContext, R.drawable.blue_button) })
            .setTitle("Seek help Area")
            .setDialogWidth(1000)
            .setTitleTextSize(25F)
            .setTitleColor(Color.BLACK)
            .setMessageTextSize(18F)
            .setMessage("Click on the contact button below each specialist and start your recovery now!")
            .setDialogBackground(Color.WHITE)
            .setMessageColor(Color.BLACK)
            //.setDialogBackgroundDrawable()
            .addActionButton(lastAction)

      /*  takePictureAction.setOnClickListener {
            dialog.cancel()
            dialog2.show()
            SharedApp.prefs.psychologists = "true"
        }
        lastAction.setOnClickListener {
            dialog2.cancel()
            SharedApp.prefs.psychologists = "true"
        }

        binding = FragmentPsychologistsBinding.inflate(layoutInflater, container, false)
        allPsychologists()

        if (SharedApp.prefs.psychologists?.isEmpty() == true){
            dialog.show()
        }*/

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
    
    private fun showData(){
        binding.viewLoading.visibility = View.GONE
        binding.psychologistRecycler.visibility = View.VISIBLE
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://http-nodejs-production-7013.up.railway.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun allPsychologists() {
        /*CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getPsychologists("psychologists")

            val psychologist= call.body()

            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    // Show recyclerview
                    if (psychologist != null) {
                        showData()
                        setRecyclerView(psychologist)
                    }
                } else {
                    //Show error
                    MotionToast.darkToast(
                        requireActivity(),
                        "Error 404",
                        "Sorry not found the searched information",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(requireActivity(), R.font.helvetica)
                    )
                }
            }


        }*/
    }

    private fun setRecyclerView(psychologistsList: List<PsychologistsResponse>) {
        val psychologistsAdapter = PsychologistsAdapter(psychologistsList)
        binding.psychologistRecycler.adapter = psychologistsAdapter
        binding.psychologistRecycler.setHasFixedSize(true)
    }
}
