package com.example.tococd.presentation.screens.psychologist

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tococd.R
import com.example.tococd.databinding.CardPsychologistsBinding
import com.example.tococd.data.remote.response.PsychologistsResponse

class PsychologistsAdapter(private val psychologistList: List<PsychologistsResponse>) :
    RecyclerView.Adapter<PsychologistsAdapter.PsychologistsVH>() {

    class PsychologistsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardPsychologistsBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsychologistsVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_psychologists, parent, false)
        return PsychologistsVH(view)
    }

    override fun onBindViewHolder(holder: PsychologistsVH, position: Int) {
        val psychologists: PsychologistsResponse = psychologistList[position]
        holder.binding.psychologistName.text = psychologists.name
        holder.binding.contactPsychologist.text = "Contact"
        holder.binding.psychologistSpecialist.text = psychologists.specialties

        //Load image with Glide
        Glide.with(holder.binding.root.context)
            .load(psychologists.imagePerson)
            .error(R.drawable.ic_error_conection)
            .into(holder.binding.imagePsychologist)

        Glide.with(holder.binding.root.context)
            .load(psychologists.imageType)
            .error(R.drawable.ic_error_conection)
            .into(holder.binding.imagePsychologistType)

        Glide.with(holder.binding.root.context)
            .load(psychologists.imageCountry)
            .error(R.drawable.ic_error_conection)
            .into(holder.binding.imagePsychologistLanguage)

        holder.binding.contactPsychologist.setOnClickListener {
            val url = Uri.parse(psychologists.contact)

            val intent = Intent(Intent.ACTION_VIEW, url)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return psychologistList.size
    }

}