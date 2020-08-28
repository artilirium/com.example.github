package com.example.components.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateView(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View =
	LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)