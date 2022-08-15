package com.example.tococd.view.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.example.tococd.R
import com.example.tococd.databinding.CardTypesBinding
import com.example.tococd.model.TypesModel

class TypesAdapter : RecyclerView.Adapter<TypesAdapter.TypesVH>() {

    private val typesList = mutableListOf<TypesModel>()

    fun setData(newTypes: List<TypesModel>) {
        typesList.clear()
        typesList.addAll(newTypes)
        notifyDataSetChanged()
    }

    class TypesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardTypesBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_types, parent, false)
        return TypesAdapter.TypesVH(view)
    }

    override fun onBindViewHolder(holder: TypesVH, position: Int) {

        val types: TypesModel = typesList[position]
        holder.binding.typesTitle.text = types.tittleTypes
        holder.binding.typesDescription.text = types.descriptionTypes
        holder.binding.typesButton.setImageResource(R.drawable.information_speech)

        //Load image with Glide
        Glide.with(holder.binding.root.context)
            .load(types.imageTypes)
            .error(R.drawable.ic_error_conection)
            .into(holder.binding.imageViewTypes)

        var like: Boolean = false

        like = likeAnimation(holder.binding.typesButton, R.raw.click_json_3, like)

        holder.binding.typesButton.setOnClickListener {
            val url = Uri.parse(types.buttonTypes)

            val intent = Intent(Intent.ACTION_VIEW, url)
            holder.binding.root.context.startActivity(intent)
        }
    }

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

    override fun getItemCount(): Int {
        return typesList.size
    }

}