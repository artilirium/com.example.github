package com.example.features.repositories.data.converter

import com.example.features.repositories.data.model.OwnerModel
import com.example.features.repositories.domain.entity.Owner
import javax.inject.Inject

class OwnerConverter @Inject constructor() {

	fun convert(model: OwnerModel): Owner =
		Owner(
			login = model.login.orEmpty(),
			id = model.id,
			avatarUrl = model.avatarUrl.orEmpty()
		)
}