package com.makam.randomapp.injection.injection.component

import com.makam.randomapp.home.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface HomeActivitySubComponent : AndroidInjector<HomeActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()

}