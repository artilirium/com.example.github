package com.example.github.di.navigation

import com.example.components.navigation.Navigator
import com.example.components.navigation.Router
import com.example.github.navigation.MainRouter
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NavigationModule {

	@Module
	companion object {

		@JvmStatic
		@Provides
		@Singleton
		fun providesMainRouter(): MainRouter =
			MainRouter()
	}

	@Binds
	@Singleton
	fun bindRouter(router: MainRouter): Router

	@Binds
	@Singleton
	fun bindNavigator(router: MainRouter): Navigator

}