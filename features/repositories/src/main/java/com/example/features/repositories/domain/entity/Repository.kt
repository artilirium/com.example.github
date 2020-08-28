package com.example.features.repositories.domain.entity

data class Repository(
	val id: Long,
	val nodeId: String,
	val name: String,
	val fullName: String,
	val owner: Owner,
	val description: String
)