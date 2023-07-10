package com.robertoazeredo.punkbeer.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeerResponse(

    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "frist_brewed")
    val fristBrewed: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "image_url")
    val imageUrl: String?
) : Parcelable