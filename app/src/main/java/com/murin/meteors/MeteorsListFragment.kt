package com.murin.meteors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.murin.meteors.adapters.MeteorsAdapter
import com.murin.meteors.databinding.FragmentMeteorsListBinding
import com.murin.meteors.viewmodel.MeteorsListViewModel

class MeteorsListFragment : Fragment() {

    private lateinit var viewModel: MeteorsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMeteorsListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = Provider.provideMeteorsListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(MeteorsListViewModel::class.java)

        val adapter = MeteorsAdapter()
        binding.rvMeteorsList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: MeteorsAdapter) {
        viewModel.getMeteors().observe(viewLifecycleOwner, Observer { meteors ->
            if (meteors != null) {
                adapter.submitList(meteors)
            }
        })
    }
}