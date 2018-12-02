package com.makam.randomapp.injection.module

import com.makam.domain.interactor.home.GetHottestLinks
import com.makam.presentation.home.HomeContract
import com.makam.presentation.home.HomePresenter
import com.makam.presentation.mapper.ImgurViewMapper
import com.makam.randomapp.home.HomeActivity
import dagger.Module
import dagger.Provides
import com.makam.randomapp.injection.scopes.PerActivity
import com.makam.remote.mapper.ImgurEntityMapper

@Module
open class HomeActivityModule {

    @PerActivity
    @Provides
    internal fun provideHomeView(homeActivity: HomeActivity): HomeContract.View {
        return homeActivity
    }

    @PerActivity
    @Provides
    internal fun provideHomePresenter(homeView: HomeContract.View, getHottestLinks: GetHottestLinks, mapper: ImgurViewMapper):
            HomeContract.Presenter {
        return HomePresenter(homeView, getHottestLinks, mapper)
    }

}
