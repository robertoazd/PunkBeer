package com.robertoazeredo.punkbeer.data.repository

import android.content.Context
import com.robertoazeredo.punkbeer.R
import com.robertoazeredo.punkbeer.data.api.PunkBeerApi
import com.robertoazeredo.punkbeer.data.api.ResultApi
import com.robertoazeredo.punkbeer.data.model.BeerResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeersRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
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
                        val error = context.getString(R.string.error_no_data)
                        ResultApi.Error(error)
                    }
                } else {
                    val errorMessageId = when (response.code()) {
                        400 -> R.string.error_400
                        401 -> R.string.error_401
                        403 -> R.string.error_403
                        404 -> R.string.error_404
                        500 -> R.string.error_500
                        503 -> R.string.error_503
                        else -> R.string.error_unknown
                    }
                    val errorMessage = context.getString(errorMessageId)
                    ResultApi.Error(errorMessage)
                }
            } catch (throwable: Throwable) {
                val error = context.getString(R.string.error_unknown)
                ResultApi.Error(error)
            }
        }
    }
}