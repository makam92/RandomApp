package com.makam.remote.model

import io.reactivex.Single
import com.makam.remote.model.ImgurModel
import retrofit2.http.GET

interface ImgurService {
    @GET("gallery/hot/viral/0.json")
    fun getHottestLinks() : Single<ImgurResponse>

    class ImgurResponse {
        lateinit var data: List<ImgurModel>
    }

}