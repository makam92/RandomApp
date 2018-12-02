package com.makam.data.source

import com.makam.data.repository.ImgurDataStore
import javax.inject.Inject

open class ImgurRemoteDataStoreFactory @Inject constructor(
    private val imgurRemoteDataStore: ImgurRemoteDataStore) {


    open fun retrieveRemoteDataStore(): ImgurDataStore {
        return imgurRemoteDataStore
    }

}