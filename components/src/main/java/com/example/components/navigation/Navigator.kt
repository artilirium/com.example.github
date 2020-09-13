package com.example.components.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface Navigator {

	fun setContainer(@IdRes containerId: Int)

	fun attach(fragmentManager: FragmentManager)

	fun detach()
}