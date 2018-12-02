package com.makam.data.repository

import com.makam.data.repository.model.ImgurEntity
import io.reactivex.Single

interface ImgurDataStore {
    fun getHottestLinks() : Single<List<ImgurEntity>>
}