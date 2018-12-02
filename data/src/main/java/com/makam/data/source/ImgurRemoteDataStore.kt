package com.makam.data.source

import com.makam.data.repository.ImgurDataStore
import com.makam.data.repository.ImgurRemote
import com.makam.data.repository.model.ImgurEntity
import io.reactivex.Single
import javax.inject.Inject

open class ImgurRemoteDataStore @Inject constructor(private val imgurRemote: ImgurRemote) : ImgurDataStore {
    override fun getHottestLinks(): Single<List<ImgurEntity>> {
        return imgurRemote.getHottestLinks()
            }

}