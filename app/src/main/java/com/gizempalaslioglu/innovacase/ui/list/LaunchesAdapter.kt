package com.gizempalaslioglu.innovacase.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gizempalaslioglu.innovacase.databinding.LaunchItemBinding
import com.gizempalaslioglu.innovacase.domain.model.LaunchItemDomainModel

class LaunchesAdapter(
    private val items: List<LaunchItemDomainModel>,
    private val onItemClick: (LaunchItemDomainModel) -> Unit
) : RecyclerView.Adapter<LaunchesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = LaunchItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onClick = onItemClick
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(
        private val binding: LaunchItemBinding,
        private val onClick: (LaunchItemDomainModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LaunchItemDomainModel) {
            with(binding) {
                Glide.with(root)
                    .load(item.imageSmall)
                    .into(launchImage)
                launchName.text = item.name
                launchDate.isVisible = item.lastLaunchDate != null
                launchDate.text = item.lastLaunchDate
                launchDetails.isVisible = item.details != null
                launchDetails.text = item.details
                launchSuccessIcon.isVisible = item.success == true

                binding.root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}
