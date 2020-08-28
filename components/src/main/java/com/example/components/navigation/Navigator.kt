package com.example.components.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface Navigator {

	fun attach(fragmentManager: FragmentManager, @IdRes containerId: Int)

	fun detach()
}