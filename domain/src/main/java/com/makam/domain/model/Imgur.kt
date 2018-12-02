package com.makam.domain.model

class Imgur(val link: String, val title: String, val ups: Int, val comments: Int,val images: List<Image>?)
class Image(val link: String)