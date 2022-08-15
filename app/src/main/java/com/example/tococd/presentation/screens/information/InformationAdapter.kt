package com.example.tococd.presentation.screens.information

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tococd.databinding.CardLayoutBinding
import com.example.tococd.model.InformationModel
import com.example.tococd.presentation.util.BaseAdapter
import com.example.tococd.utils.extension.loadImage

class InformationAdapter :
    BaseAdapter<InformationModel, InformationAdapter.InformationVH>(
        areItemsTheSame = { oldItem, newItem -> oldItem.tittleDescription == newItem.tittleDescription },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    ) {

    class InformationVH(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(information: InformationModel) {
            with(binding) {
                tittleInformation.text = information.tittleDescription
                descriptionInformation.text = information.descriptionDescription
                imageDescriptionInformation.loadImage(information.imageDescription)
            }
            setUpListeners(information)
            setUpExpandableState(information)
        }

        private fun setUpListeners(information: InformationModel) {
            binding.root.setOnClickListener {
                information.expandable = !information.expandable
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
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InformationVH(binding)
    }

    override fun onBindViewHolder(holder: InformationVH, position: Int) {
        holder.bind(getItem(position))
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
    }
}