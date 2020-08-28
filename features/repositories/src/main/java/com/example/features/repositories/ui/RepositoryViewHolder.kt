package com.example.features.repositories.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.components.extensions.inflateView
import com.example.features.repositories.R
import com.example.features.repositories.domain.entity.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.repository_item.view.avatar
import kotlinx.android.synthetic.main.repository_item.view.description
import kotlinx.android.synthetic.main.repository_item.view.title

class RepositoryViewHolder(
	onRepositoryClickListener: (Repository) -> Unit,
	parent: ViewGroup
) : RecyclerView.ViewHolder(parent.inflateView(R.layout.repository_item)) {

	lateinit var repository: Repository

	init {
		itemView.setOnClickListener { onRepositoryClickListener(repository) }
	}

	fun bind(repository: Repository) {
		this.repository = repository

		loadAvatar()
		itemView.title.text = repository.fullName
		itemView.description.text = repository.description
	}

	private fun loadAvatar() {
		Picasso.with(itemView.context)
			.load(repository.owner.avatarUrl)
			.into(itemView.avatar)
	}
}