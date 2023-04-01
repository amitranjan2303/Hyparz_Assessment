package com.hyparz.assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hyparz.assessment.R
import com.hyparz.assessment.callback.ItemActionCallBack
import com.hyparz.assessment.databinding.ItemDataBinding
import com.hyparz.assessment.model.Results
import com.hyparz.assessment.viewHolders.BaseViewHolder
import com.hyparz.assessment.viewHolders.HyparzDataViewHolder

class HyparzDataAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var dataList: ArrayList<Any>? = null
    private var itemCallback: ItemActionCallBack? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var viewHolder: BaseViewHolder?=null
        if (viewType == R.layout.item_data) {
            var viewBinding: ItemDataBinding=
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    viewType,
                    parent,
                    false
                )
            viewHolder = HyparzDataViewHolder(viewBinding)
        }
        return viewHolder!!
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is HyparzDataViewHolder) {
            dataList?.get(position).let { holder.bind(it as Results)
                holder.setItemActionCallBack(itemCallback)
            }
        }
    }

    override fun getItemCount(): Int {
        var count: Int? = 0
        count = dataList?.size!!
        return count
    }

    override fun getItemViewType(position: Int): Int {
        var item: Any? = dataList?.get(position)
        var viewType = -1;
        if (item is Results) {
            viewType = R.layout.item_data
        }
        return viewType
    }

    fun updateList(list: ArrayList<Any>) {
        dataList = list
        notifyDataSetChanged()
    }

    fun setItemCallBack(itemCallback: ItemActionCallBack?) {
        this.itemCallback = itemCallback
    }
}