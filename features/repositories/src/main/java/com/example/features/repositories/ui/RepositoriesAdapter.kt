package com.example.features.repositories.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.features.repositories.domain.entity.Repository

class RepositoriesAdapter(
	private val onRepositoryClickListener: (Repository) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	var repositories: List<Repository> = emptyList()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
		RepositoryViewHolder(onRepositoryClickListener, parent)

	override fun getItemCount(): Int =
		repositories.size

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		(holder as RepositoryViewHolder).bind(repositories[position])
	}
}