package com.example.components

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

	private val disposables = CompositeDisposable()

	override fun onDestroy() {
		disposables.dispose()
	}

	protected fun Disposable.disposeOnDestroy() {
		disposables.add(this)
	}
}