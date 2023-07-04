package com.robertoazeredo.punkbeer.data.api

import com.robertoazeredo.punkbeer.data.model.BeerResponse
import retrofit2.Response
import retrofit2.http.GET

interface PunkBeerApi {
    @GET("beers")
    suspend fun getBeers(): Response<List<BeerResponse>>
}