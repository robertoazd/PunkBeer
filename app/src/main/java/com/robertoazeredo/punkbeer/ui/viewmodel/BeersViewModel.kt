package com.robertoazeredo.punkbeer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertoazeredo.punkbeer.data.api.ResultApi
import com.robertoazeredo.punkbeer.data.model.BeerResponse
import com.robertoazeredo.punkbeer.data.repository.BeersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    private val beersRepository: BeersRepository
) : ViewModel() {

    private val _beers = MutableLiveData<List<BeerResponse>?>()
    val beers: LiveData<List<BeerResponse>?> = _beers

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getBeers() {
        viewModelScope.launch {
            when (val resultApi = beersRepository.getBeers()) {
                is ResultApi.Success -> {
                    _beers.value = resultApi.value
                }
                is ResultApi.Error -> {
                    _error.value = resultApi.message
                }
            }
        }
    }
}