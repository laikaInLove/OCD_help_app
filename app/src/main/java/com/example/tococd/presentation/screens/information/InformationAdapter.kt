package com.example.tococd.presentation.screens.information

import android.view.View
import android.view.ViewGroup
import com.example.tococd.databinding.CardLayoutBinding
import com.example.tococd.domain.model.InformationModel
import com.example.tococd.presentation.util.BaseAdapter
import com.example.tococd.presentation.util.BaseViewHolder
import com.example.tococd.utils.extension.loadImage
import com.example.tococd.utils.extension.viewBinding

class InformationAdapter :
    BaseAdapter<InformationModel, CardLayoutBinding>(
        areItemsTheSame = { oldItem, newItem -> oldItem.titleDescriptionResId == newItem.titleDescriptionResId },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    ) {

    class InformationVH(viewBinding: CardLayoutBinding) :
        BaseViewHolder<CardLayoutBinding, InformationModel>(viewBinding) {
        override fun bind(item: InformationModel) {
            with(binding) {
                tittleInformation.text = this.root.context.getString(item.titleDescriptionResId)
                descriptionInformation.text = this.root.context.getString(item.descriptionResId)
                imageDescriptionInformation.loadImage(item.imageDescription)
            }
            setUpListeners(item)
            setUpExpandableState(item)
        }

        private fun setUpListeners(information: InformationModel) {
            binding.root.setOnClickListener {
                information.expandable = !information.expandable
                setUpExpandableState(information)
            }
        }

        private fun setUpExpandableState(information: InformationModel) {
            with(binding) {
                val isExpandable = information.expandable
                descriptionInformation.visibility = if (isExpandable) View.VISIBLE else View.GONE
                touchInformation.visibility = if (!isExpandable) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationVH {
        val binding = parent.viewBinding(CardLayoutBinding::inflate, false)
        return InformationVH(binding)
    }
}