package com.hyparz.assessment.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyparz.assessment.adapters.HyparzDataAdapter
import com.hyparz.assessment.callback.ItemActionCallBack
import com.hyparz.assessment.databinding.FragmentHyparzDataBinding
import com.hyparz.assessment.model.Results
import com.hyparz.assessment.utilities.navigateToDetails
import com.hyparz.assessment.viewmodels.HyparzDataViewModel

class HyparzDataFragments : Fragment() {

    private var viewModel: HyparzDataViewModel? = null
    private var mAdapter: HyparzDataAdapter? = null
    private var binding: FragmentHyparzDataBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HyparzDataViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHyparzDataBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.getAllData()
        observeChanges()
    }

    fun observeChanges() {
        viewModel?.getAllDataLiveData()?.observe(viewLifecycleOwner, Observer { allData ->
            val list = ArrayList<Any>()
            list.addAll(allData)
            setUpRecyclerView(list)
        })
    }

    fun setUpRecyclerView(list: ArrayList<Any>) {
        binding?.rvData?.layoutManager = LinearLayoutManager(context)
        mAdapter = HyparzDataAdapter()
        mAdapter?.setItemCallBack(itemCallBack)
        mAdapter?.updateList(list)
        binding?.rvData?.adapter = mAdapter
    }

    private val itemCallBack: ItemActionCallBack = object : ItemActionCallBack {
        override fun onItemClick(position: Int?, item: Any?) {
            moveToDetailsFragment(item)
        }
    }

    private fun moveToDetailsFragment(item: Any?) {
        val bundle = Bundle()
        bundle.putParcelable("result", item as Results)
        navigateToDetails(bundle)
    }
}