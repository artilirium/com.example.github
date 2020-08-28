package com.example.features.repositories.presentation

import com.example.components.BasePresenter
import com.example.components.navigation.Router
import com.example.features.repositories.domain.entity.Repository
import com.example.features.repositories.domain.usecase.GetRepositoriesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class RepositoriesPresenter @Inject constructor(
	private val getRepositoryUseCase: GetRepositoriesUseCase,
	private val router: Router
) : BasePresenter<RepositoriesView>() {

	override fun onFirstViewAttach() {
		loadRepositories()
	}

	fun onRetryLoadClicked() {
		loadRepositories()
	}

	private fun loadRepositories() {
		viewState.showProgress()

		getRepositoryUseCase()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeBy(
				onSuccess = viewState::showRepositories,
				onError = viewState::showError
			)
			.disposeOnDestroy()
	}

	fun onRepositoryClicked(repository: Repository) {

	}

	fun onCancelClicked() {
		viewState.hideError()
		viewState.showRetryButton()
	}
}