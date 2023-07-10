package com.robertoazeredo.punkbeer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.robertoazeredo.punkbeer.R
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

        setupLayout()
    }

    private fun setupLayout() {

        val beer = args.beer
        Glide.with(binding.root.context).load(beer.imageUrl).into(binding.ivBeer)

        binding.tvName.text = getString(R.string.name, beer.name)

        if (!beer.tagline.isNullOrEmpty()) {
            binding.tvTagline.text = getString(R.string.tagline, beer.tagline)
        } else {
            binding.tvTagline.visibility = View.GONE
        }

        if (!beer.description.isNullOrEmpty()) {
            binding.tvDescription.text = getString(R.string.description , beer.description)
        } else {
            binding.tvDescription.visibility = View.GONE
        }

        binding.tvFirstBrewed.text = getString(
            R.string.first_brewed_format, beer.firstBrewed)

    }
}