package com.robertoazeredo.punkbeer.data.repository

import com.robertoazeredo.punkbeer.data.api.ResultApi
import com.robertoazeredo.punkbeer.data.model.BeerResponse

interface BeersRepository {
    suspend fun getBeers(): ResultApi<List<BeerResponse>>
}