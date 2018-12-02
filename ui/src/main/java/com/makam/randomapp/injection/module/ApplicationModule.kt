package com.makam.randomapp.injection.module

import android.app.Application
import android.content.Context
import com.bumptech.glide.BuildConfig
import com.makam.data.ImgurDataRepository
import com.makam.data.executor.JobExecutor
import com.makam.data.mapper.ImgurMapper
import com.makam.data.repository.ImgurRemote
import com.makam.data.source.ImgurRemoteDataStoreFactory
import com.makam.domain.executor.PostExecutionThread
import com.makam.domain.executor.ThreadExecutor
import com.makam.domain.repository.ImgurRepository
import com.makam.randomapp.UiThread
import com.makam.randomapp.injection.scopes.PerApplication
import com.makam.remote.mapper.ImgurEntityMapper
import com.makam.remote.model.ImgurService
import com.makam.remote.model.ImgurServiceFactory
import com.makam.remote.model.ImgurServiceImpl
import dagger.Module
import dagger.Provides


@Module
open class ApplicationModule {
    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun provideImgurRepository(factory: ImgurRemoteDataStoreFactory,
                                           mapper: ImgurMapper): ImgurRepository {
        return ImgurDataRepository(factory, mapper)
    }


    @Provides
    @PerApplication
    internal fun provideImgurRemote(service: ImgurService,
                                    mapper: ImgurEntityMapper): ImgurRemote {
        return ImgurServiceImpl(service, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideImgurService(): ImgurService {
        return ImgurServiceFactory.makeImgurService(BuildConfig.DEBUG)
    }
}