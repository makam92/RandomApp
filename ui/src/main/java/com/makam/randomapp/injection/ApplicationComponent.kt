package com.makam.randomapp.injection

import android.app.Application
import com.makam.randomapp.RandomApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.makam.randomapp.injection.module.ActivityBindingModule
import com.makam.randomapp.injection.module.ApplicationModule
import com.makam.randomapp.injection.scopes.PerApplication

@PerApplication
@Component(modules = [ActivityBindingModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: RandomApplication)

}
