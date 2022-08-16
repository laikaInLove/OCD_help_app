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
        areItemsTheSame = { oldItem, newItem -> oldItem.tittleDescription == newItem.tittleDescription },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    ) {

    class InformationVH(viewBinding: CardLayoutBinding) :
        BaseViewHolder<CardLayoutBinding, InformationModel>(viewBinding) {
        override fun bind(item: InformationModel) {
            with(binding) {
                tittleInformation.text = item.tittleDescription
                descriptionInformation.text = item.descriptionDescription
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
                expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
                touchInformation.visibility = if (!isExpandable) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationVH {
        val binding = parent.viewBinding(CardLayoutBinding::inflate, false)
        return InformationVH(binding)
    }

    //override fun onBindViewHolder(holder: InformationVH, position: Int) {
    //holder.bind(getItem(position))
//        if (position == 0) {
//            holder.binding.expandableLayout.visibility = View.GONE
//            holder.binding.touchInformation.visibility = View.GONE
//            holder.binding.tittleInformation.textSize = 20.toFloat()
//            holder.binding.informationCardView.setBackgroundResource(R.drawable.information_background_first)
//            holder.binding.touchInformation.textSize = 0.toFloat()
//            holder.binding.descriptionInformation.visibility = View.GONE
    //holder.binding.informationCardView.layoutParams.height = 850

//            val typeface: Typeface =
//                holder.binding.root.resources.getFont(R.font.poppins_regular)
//            holder.binding.tittleInformation.setTypeface(typeface, Typeface.NORMAL)
//        } else {
//            val typeface: Typeface =
//                holder.binding.root.resources.getFont(R.font.montserrat_regular)
//            holder.binding.tittleInformation.setTypeface(typeface, Typeface.BOLD)

//            holder.binding.informationCardView.setBackgroundResource(R.drawable.information_background)
//            holder.binding.tittleInformation.textSize = 23.toFloat()
    //holder.binding.informationCardView.layoutParams.height = 415

    //}

    //holder.binding.informationCardView
    //}
}