package com.makam.remote.model

import com.makam.data.repository.ImgurRemote
import com.makam.data.repository.model.ImgurEntity
import com.makam.remote.mapper.ImgurEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class ImgurServiceImpl @Inject constructor(private val imgurService: ImgurService, private val imgurEntityMapper: ImgurEntityMapper) : ImgurRemote{
    object filter {
        val FilterTypes: MutableList<String> = mutableListOf("image/jpeg", "image/png")
    }

    override fun getHottestLinks(): Single<List<ImgurEntity>> {
                    return imgurService.getHottestLinks().map { imgurResponse ->
                        imgurResponse.data
                            .filter {it.images != null && it.images.any { image ->  filter.FilterTypes.contains(image.type)} }
                            .map { listItem ->
                                imgurEntityMapper.mapFromRemote(listItem)
            }
        }
    }

}