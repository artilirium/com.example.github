package com.example.features.repositories.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryModel(
	val id: Long,
	@SerializedName("node_id") val nodeId: String?,
	val name: String?,
	@SerializedName("full_name") val fullName: String?,
	val owner: OwnerModel,
	val description: String?
)