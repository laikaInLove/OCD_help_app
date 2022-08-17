package com.example.tococd.presentation.screens.psychologist

import android.view.ViewGroup
import com.example.tococd.databinding.CardPsychologistsBinding
import com.example.tococd.domain.model.Psychologist
import com.example.tococd.presentation.util.BaseAdapter
import com.example.tococd.presentation.util.BaseViewHolder
import com.example.tococd.utils.extension.loadUrlImage
import com.example.tococd.utils.extension.viewBinding

class PsychologistsAdapter(
    private val onClickItem: (url: String) -> Unit
) :
    BaseAdapter<Psychologist, CardPsychologistsBinding>(
        areItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsychologistsVH {
        val binding = parent.viewBinding(CardPsychologistsBinding::inflate, false)
        return PsychologistsVH(binding)
    }

    inner class PsychologistsVH(viewBinding: CardPsychologistsBinding) :
        BaseViewHolder<CardPsychologistsBinding, Psychologist>(viewBinding) {

        override fun bind(item: Psychologist) {
            with(binding) {
                psychologistName.text = item.name
                contactPsychologist.text = "Contact"
                psychologistSpecialist.text = item.specialties
                imagePsychologist.loadUrlImage(item.imagePerson)
                imagePsychologistType.loadUrlImage(item.imageType)
                imagePsychologistLanguage.loadUrlImage(item.imageCountry)
            }
            setUpListeners(item)
        }

        private fun setUpListeners(psychologist: Psychologist) {
            binding.contactPsychologist.setOnClickListener {
                onClickItem(psychologist.contact)
            }
        }
    }
}