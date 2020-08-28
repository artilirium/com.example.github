package com.example.github.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class GithubInterceptor @Inject constructor(): Interceptor {

	private companion object {
		const val ACCEPT_KEY = "Accept"
		const val ACCEPT_VALUE = "application/vnd.github.v3+json"
	}

	override fun intercept(chain: Interceptor.Chain): Response =
		chain.proceed(getRequest(chain))

	private fun getRequest(chain: Interceptor.Chain): Request =
		chain.request()
			.newBuilder()
			.addHeader(ACCEPT_KEY, ACCEPT_VALUE)
			.build()
}