package com.robertoazeredo.punkbeer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.robertoazeredo.punkbeer.data.model.BeerResponse
import com.robertoazeredo.punkbeer.databinding.ItemBeerBinding

class BeersAdapter(
    val itemClick: (beer: BeerResponse) -> Unit = {}
): RecyclerView.Adapter<BeersAdapter.BeersViewHolder>() {

    private var beers: List<BeerResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): BeersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBeerBinding.inflate(layoutInflater, parent, false)
        return BeersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeersViewHolder , position: Int) {
        holder.bind(beers[position], itemClick)
    }

    override fun getItemCount() = beers.size

    fun insertBeers(beers: List<BeerResponse>) {
        notifyItemRangeRemoved(0, this.beers.size)
        this.beers = beers
        notifyItemInserted(this.beers.size)
    }

    class BeersViewHolder(
        private val binding: ItemBeerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: BeerResponse, itemClick: (beer: BeerResponse) -> Unit = {}) {
            Glide.with(binding.root.context).load(beer.imageUrl).into(binding.ivBeer)
            binding.root.setOnClickListener {
                itemClick.invoke(beer)
            }
        }
    }
}
