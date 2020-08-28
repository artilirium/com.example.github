package com.example.features.repositories.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.components.BaseFragment
import com.example.features.repositories.R
import com.example.features.repositories.domain.entity.Repository
import com.example.features.repositories.presentation.RepositoriesPresenter
import com.example.features.repositories.presentation.RepositoriesView
import kotlinx.android.synthetic.main.repositories_fragment.progress
import kotlinx.android.synthetic.main.repositories_fragment.repositoriesView
import kotlinx.android.synthetic.main.repositories_fragment.retry
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class RepositoriesFragment : BaseFragment(), RepositoriesView {

	companion object {
		fun create(): Fragment =
			RepositoriesFragment()
	}

	override val layoutId: Int = R.layout.repositories_fragment

	@Inject
	@InjectPresenter
	lateinit var presenter: RepositoriesPresenter

	private val adapter = RepositoriesAdapter(
		onRepositoryClickListener = { presenter.onRepositoryClicked(it) }
	)

	private var alertDialog: AlertDialog? = null

	@ProvidePresenter
	fun providePresenter(): RepositoriesPresenter =
		presenter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		repositoriesView.adapter = adapter
	}

	override fun showRepositories(repositories: List<Repository>) {
		repositoriesView.visibility = View.VISIBLE
		progress.visibility = View.GONE

		adapter.repositories = repositories
	}

	override fun hideError() {
		hideErrorDialog()
	}

	override fun showError(error: Throwable) {
		progress.visibility = View.GONE

		alertDialog = showErrorDialog(error)
	}

	private fun showErrorDialog(error: Throwable): AlertDialog =
		AlertDialog.Builder(requireContext())
			.setTitle(R.string.error)
			.setMessage(error.message)
			.setCancelable(false)
			.setPositiveButton(R.string.retry) { _, _ ->
				presenter.onRetryLoadClicked()
			}
			.setNegativeButton(R.string.cancel) { _, _ ->
				presenter.onCancelClicked()
			}
			.show()

	override fun onDestroyView() {
		super.onDestroyView()
		hideErrorDialog()
	}

	private fun hideErrorDialog() {
		alertDialog?.cancel()
		alertDialog = null
	}

	override fun showProgress() {
		progress.visibility = View.VISIBLE
		retry.visibility = View.GONE
		repositoriesView.visibility = View.GONE
	}

	override fun showRetryButton() {
		retry.visibility = View.VISIBLE
		repositoriesView.visibility = View.GONE
	}
}