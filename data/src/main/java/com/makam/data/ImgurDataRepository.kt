package com.makam.data

import com.makam.data.mapper.ImgurMapper
import com.makam.data.source.ImgurRemoteDataStoreFactory
import com.makam.domain.model.Imgur
import com.makam.domain.repository.ImgurRepository
import io.reactivex.Single
import javax.inject.Inject

class ImgurDataRepository @Inject constructor(private val factory: ImgurRemoteDataStoreFactory, private val imgurMapper: ImgurMapper) : ImgurRepository {

    override fun getHottestLinks(): Single<List<Imgur>> {
        val dataStore = factory.retrieveRemoteDataStore()
        return dataStore.getHottestLinks()
            .map { list ->
                list.map { listItem ->
                    imgurMapper.mapFromEntity(listItem)
                }
            }
    }

}