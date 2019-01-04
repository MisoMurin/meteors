package com.murin.meteors.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.murin.meteors.data.Meteor

class MeteorDiffCallback: DiffUtil.ItemCallback<Meteor>() {

    override fun areItemsTheSame(oldItem: Meteor, newItem: Meteor): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Meteor, newItem: Meteor): Boolean {
        return oldItem == newItem
    }
}
