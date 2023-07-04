package com.robertoazeredo.punkbeer.data.api

sealed class ResultApi<out T> {
    data class Success<out T>(val value: T): ResultApi<T>()
    data class Error(val message: String): ResultApi<Nothing>()
}
