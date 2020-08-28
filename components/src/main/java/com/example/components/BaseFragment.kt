package com.example.components

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), HasAndroidInjector {

	abstract val layoutId: Int

	@Inject
	lateinit var androidInjector: DispatchingAndroidInjector<Any>

	override fun onAttach(context: Context) {
		AndroidSupportInjection.inject(this)
		super.onAttach(context)
	}

	override fun androidInjector(): AndroidInjector<Any> =
		androidInjector

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(layoutId, container, false)
}