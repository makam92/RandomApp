package com.makam.randomapp.injection.module

import com.makam.randomapp.home.HomeActivity
import com.makam.randomapp.injection.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    abstract fun bindMainActivity(): HomeActivity

}