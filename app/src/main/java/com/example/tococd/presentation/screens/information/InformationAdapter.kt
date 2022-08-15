package com.example.tococd.presentation.screens.information

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tococd.R
import com.example.tococd.databinding.CardLayoutBinding
import com.example.tococd.model.InformationModel


class InformationAdapter(private val informationList: List<InformationModel>) :
    RecyclerView.Adapter<InformationAdapter.InformationVH>() {

    class InformationVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return InformationVH(view)
    }

    override fun onBindViewHolder(holder: InformationVH, position: Int) {

        val information: InformationModel = informationList[position]
        holder.binding.tittleInformation.text = information.tittleDescription
        holder.binding.descriptionInformation.text = information.descriptionDescription

        //Load image with Glide
        Glide.with(holder.binding.root.context)
            .load(information.imageDescription)
            .error(R.drawable.ic_error_conection)
            .into(holder.binding.imageDescriptionInformation)

        val isExpandable: Boolean = informationList[position].expandable

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


            holder.binding.expandableLayout.visibility =
                if (isExpandable) View.VISIBLE else View.GONE
            holder.binding.touchInformation.visibility =
                if (!isExpandable) View.VISIBLE else View.GONE
//            holder.binding.informationCardView.setBackgroundResource(R.drawable.information_background)
//            holder.binding.tittleInformation.textSize = 23.toFloat()
            //holder.binding.informationCardView.layoutParams.height = 415

            holder.binding.relativeLayout.setOnClickListener {
                val details = informationList[position]
                details.expandable = !details.expandable
                notifyItemChanged(position)
            }
        //}

        holder.binding.informationCardView
    }

    override fun getItemCount(): Int {
        return informationList.size
    }

}