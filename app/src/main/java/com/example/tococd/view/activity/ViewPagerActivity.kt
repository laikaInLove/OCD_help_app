package com.example.tococd.view.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.tococd.R
import com.example.tococd.view.adapter.ViewPagerAdapter
import com.example.tococd.databinding.ViewPagerActivityBinding
import com.example.tococd.model.Board
import com.example.tococd.utils.SharedApp

class ViewPagerActivity : AppCompatActivity(), ViewPagerAdapter.OnItemSelected {

    private lateinit var binding: ViewPagerActivityBinding
    private lateinit var boardList : List<Board>

    override fun onCreate(savedInstanceState: Bundle?) {

        // (If) for check if SharedApp is complete already
        if (SharedApp.prefs.name?.isNotEmpty() == true) {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        super.onCreate(savedInstanceState)
        binding = ViewPagerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        boardList = listOf(
            Board(
                viewPagerBackground = R.color.deep_pool,
                viewPagerImage = R.raw.bear_sad,
                tittle = "Are You confused and have questions?",
                description = "OCD generates many doubts and questions such as: What is OCD? Do I have OCD? How can I get better? Well, here you will find the answer to these and other questions."
            ),

            Board(
                viewPagerBackground = R.color.solid_soft_purple,
                viewPagerImage = R.raw.stressed,
                tittle = "OCD can be very confusing and stressful...",
                description = "We know how confusing, stressful, anxious and frustrating OCD can be, yet there is recovery and the first step to begin recovery is to get informed and know how OCD works.",
            ),

                Board(
                    viewPagerBackground = R.color.grass_green,
                    viewPagerImage = R.raw.happy_meditating,
                    tittle = "That's why UsHelp is here to answer all your questions!",
                    description = "UsHelp has been created to solve the most frequently asked questions about OCD, plus you'll find OCD specialists to help you and your loved ones."
                )
            )

        val adapter = ViewPagerAdapter(boardList, this)
        binding.viewPager.adapter = adapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_LTR

        binding.indicator.setViewPager(binding.viewPager)

    }

    override fun onClickListener(position: Int) {
        if (position == (boardList.size - 1)){
                val intent = Intent(this, YourNameIs::class.java)
                startActivity(intent)
                //Next Activity

        } else {
            binding.viewPager.setCurrentItem((position + 1),true)
        }
    }
}