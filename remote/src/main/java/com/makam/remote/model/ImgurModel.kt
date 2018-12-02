package com.makam.remote.model

import com.google.gson.annotations.SerializedName

class ImgurModel(val link: String, val title: String, val ups: Int, @SerializedName("comment_count") val comments: Int, val images: List<Image>?)
class Image(val link: String, val type: String)