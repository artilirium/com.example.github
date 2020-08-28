package com.example.features.main.ui

import android.os.Bundle
import com.example.components.navigation.Navigator
import com.example.features.main.R
import com.example.features.main.presentation.MainPresenter
import com.example.features.main.presentation.MainView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView, HasAndroidInjector {
	@Inject
	@InjectPresenter
	lateinit var presenter: MainPresenter

	@Inject
	lateinit var androidInjector: DispatchingAndroidInjector<Any>

	@ProvidePresenter
	fun providePresenter(): MainPresenter = presenter

	override fun androidInjector(): AndroidInjector<Any> =
		androidInjector

	@Inject
	lateinit var navigator: Navigator

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)
		navigator.attach(supportFragmentManager, R.id.container)
	}

	override fun onDestroy() {
		navigator.detach()
		super.onDestroy()
	}
}