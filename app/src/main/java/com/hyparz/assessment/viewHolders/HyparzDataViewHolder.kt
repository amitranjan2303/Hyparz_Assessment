package com.hyparz.assessment.viewHolders

import com.hyparz.assessment.callback.ItemActionCallBack
import com.hyparz.assessment.databinding.ItemDataBinding
import com.hyparz.assessment.model.Results
import com.hyparz.assessment.utilities.CircleTransform
import com.squareup.picasso.Picasso

class HyparzDataViewHolder(val binding: ItemDataBinding) : BaseViewHolder(binding.root) {

    private var itemActionCallBack: ItemActionCallBack? = null

    override fun bind(item: Any) {
        item?.let { itemAny ->
            val item: Results = (itemAny as Results)
            binding.title.text = item.name?.title + " " + item.name?.first + " " + item.name?.last
            binding.subtitle.text = "Age : " + item?.dob?.age
            binding.subtitle1.text = item.cell
            item?.picture?.large.let {
                Picasso.get().load(it)
                    .transform(CircleTransform())
                    .resize(150, 150)
                    .into(binding.image)
            }

            binding.root.setOnClickListener {
                itemActionCallBack?.let { callback ->
                    callback.onItemClick(adapterPosition,item)
                }
            }
        }

    }

    fun setItemActionCallBack(itemActionCallBack: ItemActionCallBack?) {
        this.itemActionCallBack=itemActionCallBack
    }

}