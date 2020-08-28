package com.example.features.repositories.data.model

import com.google.gson.annotations.SerializedName

data class OwnerModel(
	val login: String?,
	val id: Long,
	@SerializedName("avatar_url") val avatarUrl: String?
)