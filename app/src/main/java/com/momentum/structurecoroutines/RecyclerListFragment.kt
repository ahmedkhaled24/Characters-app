package com.momentum.structurecoroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.momentum.structurecoroutines.adapter.RecyclerDataAdapter
import com.momentum.structurecoroutines.models.RecyclerData
import com.momentum.structurecoroutines.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.*

class RecyclerListFragment : Fragment() {

    private lateinit var adapter: RecyclerDataAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        configViewModel()
        return view
    }

    private fun initRecyclerView(data: ArrayList<RecyclerData>) {
        adapter = RecyclerDataAdapter()
        adapter.setUpData(data)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerId.addItemDecoration(decoration)
        recyclerId.adapter = adapter
    }


    private fun configViewModel(){
        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                initRecyclerView(it.items)
            }
        }
        viewModel.makeApiCall()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerListFragment()
    }
}
