package com.robertoazeredo.punkbeer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.robertoazeredo.punkbeer.databinding.FragmentBeerDetailBinding

class BeerDetailFragment : Fragment() {

    private val args: BeerDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentBeerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBeerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        println(args.beer)
    }
}