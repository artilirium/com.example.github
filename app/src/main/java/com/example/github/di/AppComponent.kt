package com.example.github.di

import android.content.Context
import com.example.github.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [AppModule::class])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        @BindsInstance
        abstract fun context(context: Context): Builder
    }
}