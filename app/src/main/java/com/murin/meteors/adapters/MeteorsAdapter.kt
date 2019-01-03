package com.murin.meteors.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.murin.meteors.MeteorsListFragmentDirections
import com.murin.meteors.data.Meteor
import com.murin.meteors.databinding.ItemMeteorBinding

class MeteorsAdapter : ListAdapter<Meteor, MeteorsAdapter.ViewHolder>(MeteorDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meteor = getItem(position)
        holder.apply {
            bind(createOnClickListener(meteor.id), meteor)
            itemView.tag = meteor
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMeteorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    private fun createOnClickListener(meteorId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = MeteorsListFragmentDirections
                .ActionMeteorsFragmentToMeteorLandingMapFragment().setMeteorId(meteorId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ItemMeteorBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Meteor) {
            binding.apply {
                clickListener = listener
                meteor = item
                executePendingBindings()
            }
        }
    }
}
