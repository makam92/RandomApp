package com.makam.presentation.mapper

import com.makam.domain.model.Imgur
import com.makam.presentation.model.ImgurView
import javax.inject.Inject

open class ImgurViewMapper @Inject constructor(): Mapper<ImgurView, Imgur> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: Imgur): ImgurView {
        return ImgurView(type.link, type.title, type.ups, type.comments, type.images!!.map { it.link })
    }


}