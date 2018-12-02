package com.makam.data.repository

import com.makam.data.repository.model.ImgurEntity
import io.reactivex.Single

interface ImgurRemote{
    fun getHottestLinks() : Single<List<ImgurEntity>>
}