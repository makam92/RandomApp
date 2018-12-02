package com.makam.domain.interactor.home

import com.makam.domain.SingleUseCase
import com.makam.domain.executor.PostExecutionThread
import com.makam.domain.executor.ThreadExecutor
import com.makam.domain.model.Imgur
import com.makam.domain.repository.ImgurRepository
import io.reactivex.Single
import javax.inject.Inject

open class GetHottestLinks @Inject constructor(val imgurRepository: ImgurRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : SingleUseCase<List<Imgur>, Void?>(threadExecutor, postExecutionThread){

    override fun buildUseCaseObservable(params: Void?): Single<List<Imgur>> {
        return imgurRepository.getHottestLinks()
    }
}