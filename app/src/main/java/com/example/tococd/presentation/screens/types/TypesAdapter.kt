package com.example.tococd.presentation.screens.types

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tococd.R
import com.example.tococd.databinding.CardTypesBinding
import com.example.tococd.domain.model.TypesModel
import com.example.tococd.presentation.util.BaseAdapter
import com.example.tococd.presentation.util.BaseViewHolder
import com.example.tococd.utils.extension.loadUrlImage

class TypesAdapter(private val onItemClick: (url: String) -> Unit) :
    BaseAdapter<TypesModel, CardTypesBinding>(
        areItemsTheSame = { oldItem, newItem -> oldItem.tittleTypes == newItem.tittleTypes },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    ) {

    inner class TypesVH(viewBinding: CardTypesBinding) :
        BaseViewHolder<CardTypesBinding, TypesModel>(viewBinding) {
        override fun bind(item: TypesModel) {
            with(binding) {
                typesTitle.text = item.tittleTypes
                typesDescription.text = item.descriptionTypes
                imageViewTypes.loadUrlImage(item.imageTypes)
            }
            setUpListeners(item)
        }

        private fun setUpListeners(types: TypesModel) {
            binding.typesButton.setOnClickListener {
                onItemClick(types.buttonTypes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesVH {
        val binding = CardTypesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypesVH(binding)
    }
}