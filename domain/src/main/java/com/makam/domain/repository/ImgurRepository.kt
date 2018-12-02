package com.makam.domain.repository

import com.makam.domain.model.Imgur
import io.reactivex.Single

interface ImgurRepository {
    fun getHottestLinks() : Single<List<Imgur>>
}