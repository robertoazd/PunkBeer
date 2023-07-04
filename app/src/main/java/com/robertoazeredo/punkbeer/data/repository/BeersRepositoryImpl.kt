package com.robertoazeredo.punkbeer.data.repository

import com.robertoazeredo.punkbeer.data.api.PunkBeerApi
import com.robertoazeredo.punkbeer.data.api.ResultApi
import com.robertoazeredo.punkbeer.data.model.BeerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeersRepositoryImpl @Inject constructor(
    private val punkBeerApi: PunkBeerApi
) : BeersRepository {

    override suspend fun getBeers(): ResultApi<List<BeerResponse>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = punkBeerApi.getBeers()
                val body = response.body()
                if (response.isSuccessful) {
                    if (body != null) {
                        ResultApi.Success(body)
                    } else {
                        ResultApi.Error("Error no data")
                    }
                } else {
                    ResultApi.Error("Generic error")
                }
            } catch (throwable: Throwable) {
                ResultApi.Error("Error unknown")
            }
        }
    }
}