package com.murin.meteors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.murin.meteors.databinding.FragmentMeteorsListBinding

class MeteorsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMeteorsListBinding.inflate(inflater, container, false)

        return binding.root
    }
}