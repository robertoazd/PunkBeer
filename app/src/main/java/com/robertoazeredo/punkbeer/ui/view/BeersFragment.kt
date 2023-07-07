package com.robertoazeredo.punkbeer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertoazeredo.punkbeer.R
import com.robertoazeredo.punkbeer.databinding.FragmentBeersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeersFragment : Fragment() {

    private lateinit var binding: FragmentBeersBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBeersBinding.inflate(inflater, container, false)
        return binding.root
    }
}
