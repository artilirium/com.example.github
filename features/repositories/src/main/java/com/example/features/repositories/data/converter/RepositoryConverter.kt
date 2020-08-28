package com.example.features.repositories.data.converter

import com.example.features.repositories.data.model.RepositoryModel
import com.example.features.repositories.domain.entity.Repository
import javax.inject.Inject

class RepositoryConverter @Inject constructor(private val ownerConverter: OwnerConverter) {

	fun convert(model: RepositoryModel): Repository =
		Repository(
			id = model.id,
			nodeId = model.nodeId.orEmpty(),
			name = model.name.orEmpty(),
			fullName = model.fullName.orEmpty(),
			owner = ownerConverter.convert(model.owner),
			description = model.description.orEmpty()
		)
}