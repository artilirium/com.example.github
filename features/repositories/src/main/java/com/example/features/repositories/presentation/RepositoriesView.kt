package com.example.features.repositories.presentation

import com.example.features.repositories.domain.entity.Repository
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoriesView : MvpView {

	private companion object {
		const val ERROR = "ERROR"
	}

	fun showRepositories(repositories: List<Repository>)

	fun showProgress()

	fun showRetryButton()

	@StateStrategyType(AddToEndSingleStrategy::class, tag = ERROR)
	fun showError(error: Throwable)

	@StateStrategyType(AddToEndSingleStrategy::class, tag = ERROR)
	fun hideError()
}