package com.example.github.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.components.navigation.Navigator
import com.example.components.navigation.REPOSITORIES_SCREEN
import com.example.components.navigation.Router
import com.example.features.repositories.ui.RepositoriesFragment
import javax.inject.Inject

class MainRouter @Inject constructor() : Router, Navigator {

	@IdRes
	private var containerId: Int = 0
	private var isFirstFragment = true
	private var fragmentManager: FragmentManager? = null

	override fun attach(fragmentManager: FragmentManager, @IdRes containerId: Int) {
		this.containerId = containerId
		this.fragmentManager = fragmentManager
	}

	override fun detach() {
		fragmentManager = null
	}

	override fun moveTo(screen: String) {
		fragmentManager
			?.takeIf { it.fragmentNotExist(screen) }
			?.let { moveToScreen(screen, it) }
	}

	private fun moveToScreen(screen: String, fragmentManager: FragmentManager) {
		val fragment = getFragment(screen)

		fragmentManager.beginTransaction()
			.injectFragment(fragment, screen)
			.commit()
	}

	private fun FragmentManager.fragmentNotExist(fragmentTag: String): Boolean =
		findFragmentByTag(fragmentTag) == null

	private fun getFragment(screen: String): Fragment =
		when (screen) {
			REPOSITORIES_SCREEN -> RepositoriesFragment.create()
			else                -> throw Throwable("Attempt to move to non-existent screen - ($screen)")
		}

	private fun FragmentTransaction.injectFragment(
		fragment: Fragment,
		fragmentTag: String
	): FragmentTransaction =
		if (isFirstFragment) {
			isFirstFragment = false
			add(containerId, fragment, fragmentTag)
		} else {
			replace(containerId, fragment, fragmentTag)
			setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
			addToBackStack(fragmentTag)
		}

	override fun popTo(screen: String) {
		fragmentManager?.let { popToScreen(screen, it) }
	}

	private fun popToScreen(screen: String, fragmentManager: FragmentManager) {
		while (getCurrentScreen(fragmentManager) != screen) {
			fragmentManager.popBackStackImmediate()
		}
	}

	private fun getCurrentScreen(fragmentManager: FragmentManager): String? =
		fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name

}