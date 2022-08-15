package com.example.tococd.presentation.screens.types

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.tococd.R
import com.example.tococd.databinding.CardTypesBinding
import com.example.tococd.model.TypesModel
import com.example.tococd.presentation.util.BaseAdapter
import com.example.tococd.utils.extension.loadUrlImage

class TypesAdapter : BaseAdapter<TypesModel,TypesAdapter.TypesVH>(
    areItemsTheSame = { oldItem, newItem -> oldItem.tittleTypes == newItem.tittleTypes },
    areContentsTheSame = {oldItem, newItem -> oldItem == newItem }
) {

    class TypesVH(private val binding: CardTypesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(types: TypesModel) {
            with(binding) {
                typesTitle.text = types.tittleTypes
                typesDescription.text = types.descriptionTypes
                typesButton.setImageResource(R.drawable.information_speech)
                imageViewTypes.loadUrlImage(types.imageTypes)
            }
            setUpListeners(types)
        }

        private fun setUpListeners(types: TypesModel) {
            binding.typesButton.setOnClickListener {
                val url = Uri.parse(types.buttonTypes)
                val intent = Intent(Intent.ACTION_VIEW, url)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesVH {
        val binding = CardTypesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypesVH(binding)
    }

    override fun onBindViewHolder(holder: TypesVH, position: Int) {
        holder.bind(getItem(position))
        //TODO: CHECK THIS LIKE FUNCTIONALITY
        /*var like: Boolean = false
        like = likeAnimation(holder.binding.typesButton, R.raw.click_json_3, like)*/

    }

    //TODO: CHECK THIS FUNCTION
    private fun likeAnimation(
        imageView: LottieAnimationView,
        animation: Int,
        like: Boolean
    ): Boolean {

        imageView.setAnimation(animation)
        imageView.repeatCount = LottieDrawable.INFINITE
        imageView.playAnimation()
        //imageView.setImageResource(R.drawable.information_speech)

        return !like
    }
}