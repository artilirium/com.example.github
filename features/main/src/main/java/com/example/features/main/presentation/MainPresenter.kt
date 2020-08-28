package com.example.features.main.presentation

import com.example.components.BasePresenter
import com.example.components.navigation.REPOSITORIES_SCREEN
import com.example.components.navigation.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : BasePresenter<MainView>() {

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
		router.moveTo(REPOSITORIES_SCREEN)
	}
}