package com.example.github.di.network

import com.example.github.BuildConfig
import com.example.github.network.GithubInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
		Retrofit
			.Builder()
			.baseUrl(BuildConfig.SERVER_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
			.client(okHttpClient)
			.build()

	@Provides
	@Singleton
	fun provideOkHttpClient(
		loggerInterceptor: HttpLoggingInterceptor,
		githubInterceptor: GithubInterceptor
	): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(loggerInterceptor)
			.addInterceptor(githubInterceptor)
			.build()

	@Provides
	@Singleton
	fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
		val logLevel = if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor.Level.BODY
		} else {
			HttpLoggingInterceptor.Level.NONE
		}

		return HttpLoggingInterceptor().apply {
			level = logLevel
		}
	}
}