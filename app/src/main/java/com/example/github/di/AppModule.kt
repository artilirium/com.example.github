package com.example.github.di

import com.example.features.main.ui.MainActivity
import com.example.github.di.navigation.NavigationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {

	@Singleton
	@ContributesAndroidInjector(modules = [ActivityModule::class, NavigationModule::class])
	fun contributeMainActivity(): MainActivity
}