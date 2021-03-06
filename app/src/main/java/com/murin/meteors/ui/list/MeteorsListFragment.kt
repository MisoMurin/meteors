package com.murin.meteors.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import com.google.android.material.snackbar.Snackbar
import com.murin.meteors.Provider
import com.murin.meteors.R
import com.murin.meteors.data.MeteorsRepository.FetchStatus.*
import com.murin.meteors.databinding.FragmentMeteorsListBinding

class MeteorsListFragment : Fragment() {

    private lateinit var viewModel: MeteorsListViewModel
    private lateinit var binding: FragmentMeteorsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeteorsListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = Provider.provideMeteorsListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(MeteorsListViewModel::class.java)

        val adapter = MeteorsAdapter()
        binding.rvMeteorsList.addItemDecoration(DividerItemDecoration(context, VERTICAL))
        binding.rvMeteorsList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: MeteorsAdapter) {
        viewModel.meteors.observe(viewLifecycleOwner, Observer { meteors ->
            val meteorsCount = meteors?.size ?: 0
            if (meteorsCount > 0) {
                adapter.submitList(meteors)
            }
            binding.tvMeteorsCount.text = String.format(
                resources.getQuantityString(
                    R.plurals.meteors_count,
                    meteors?.size ?: 0
                ),
                meteorsCount
            )
            binding.tvMeteorsCount.visibility = View.VISIBLE
        })

        viewModel.fetchStatus.observe(viewLifecycleOwner, Observer { status ->
            when (status) {
                SUCCESS -> {}
                FAILURE -> snackbar(R.string.fetch_error)
                FETCHING -> snackbar(R.string.fetching)
                else -> snackbar(R.string.unknown_state)
            }
        })
    }

    private fun snackbar(messageId: Int) =
        Snackbar.make(binding.rvMeteorsList, messageId, Snackbar.LENGTH_LONG).show()
}
