package com.example.tococd.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.tococd.R
import com.example.tococd.databinding.BoardItemBinding
import com.example.tococd.model.Board

class ViewPagerAdapter(
    private val boarList: List<Board>,
    private val onItemSelected: OnItemSelected? = null
) : RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)
        return BoardViewHolder(view, onItemSelected)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boarList[position])
    }

    override fun getItemCount(): Int {
        return boarList.size
    }

    inner class BoardViewHolder(
        itemView: View,
        private val onItemSelected: OnItemSelected? = null
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = BoardItemBinding.bind(itemView)

        fun bind(board: Board) = with(itemView) {
            binding.container.background =
                ContextCompat.getDrawable(context, board.viewPagerBackground)
            binding.textViewTitle.text = board.tittle
            binding.textViewDescription.text = board.description
            if (adapterPosition == boarList.size - 1) {
                binding.nextButton.text = "Start"
            }
            binding.nextButton.setOnClickListener {
                onItemSelected?.onClickListener(adapterPosition)
            }

            var like: Boolean = false
            like = likeAnimation(binding.imageView1 as LottieAnimationView, board.viewPagerImage, like)
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

    }

    interface OnItemSelected {
        fun onClickListener(position: Int)
    }
}


