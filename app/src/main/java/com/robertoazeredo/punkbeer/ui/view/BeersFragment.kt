package com.robertoazeredo.punkbeer.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.robertoazeredo.punkbeer.databinding.FragmentBeersBinding
import com.robertoazeredo.punkbeer.ui.adapter.BeersAdapter
import com.robertoazeredo.punkbeer.ui.viewmodel.BeersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeersFragment : Fragment() {

    private lateinit var binding: FragmentBeersBinding
    private val viewModel: BeersViewModel by viewModels()

    private val adapter by lazy {
        BeersAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBeersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        if (viewModel.beers.value == null) {
            viewModel.getBeers()
        }

        setupLayout()
        setupListeners()
        setupObservable()
    }

    private fun setupLayout() {
        binding.rcBeers.adapter = adapter

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rcBeers)
    }

    private fun setupListeners() {
        adapter.itemClick = { beer ->
            println("Criar fragment de detalhes da beer")
        }
    }

    private fun setupObservable() {
        viewModel.beers.observe(viewLifecycleOwner) { beers ->
            if (!beers.isNullOrEmpty()) {
                adapter.insertBeers(beers)
            } else {
                Toast.makeText(context, "Lista vazia", Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility = View.INVISIBLE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()

            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}
