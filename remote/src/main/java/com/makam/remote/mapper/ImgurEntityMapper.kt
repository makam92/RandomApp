package com.makam.remote.mapper

import com.makam.data.repository.model.ImageEntity
import com.makam.data.repository.model.ImgurEntity
import com.makam.remote.model.ImgurModel
import javax.inject.Inject

open class ImgurEntityMapper @Inject constructor(): EntityMapper<ImgurModel, ImgurEntity> {

    override fun mapFromRemote(type: ImgurModel): ImgurEntity {

            return ImgurEntity(type.link, type.title, type.ups, type.comments,
                type.images!!.map { ImageEntity(it.link) }
            )
    }

}
