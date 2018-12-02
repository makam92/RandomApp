package com.makam.data.mapper

import com.makam.data.repository.model.ImageEntity
import com.makam.data.repository.model.ImgurEntity
import com.makam.domain.model.Image
import com.makam.domain.model.Imgur
import javax.inject.Inject

open class ImgurMapper @Inject constructor() : Mapper<ImgurEntity, Imgur>{
    override fun mapToEntity(type: Imgur): ImgurEntity {
        return ImgurEntity(type.link, type.title, type.ups, type.comments, type.images!!.map { ImageEntity(it.link) })
    }

    override fun mapFromEntity(type: ImgurEntity): Imgur {
        return Imgur(type.link, type.title, type.ups, type.comments, type.images!!.map { Image(it.link) })
    }

}