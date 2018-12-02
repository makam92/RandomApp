package com.makam.data.repository.model

class ImgurEntity(val link: String, val title: String, val ups: Int, val comments: Int, val images: List<ImageEntity>)
class ImageEntity(val link: String)