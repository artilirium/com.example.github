package com.example.github

import android.app.Application
import com.example.github.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        AndroidInjector { activityInjector.maybeInject(it) }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .context(this)
            .create(this)
            .inject(this)
    }
}
