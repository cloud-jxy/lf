package com.jocker.jlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jocker.jlife.beans.Subjects
import com.jocker.jlife.databinding.ItemIntheaterBinding

class Top250ListAdapter :
        PagedListAdapter<Subjects, Top250ListAdapter.Top250AdapterHolder>(InTheaterDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Top250AdapterHolder {
        val binding = ItemIntheaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Top250AdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: Top250AdapterHolder, position: Int) {
        val subjectsBean = getItem(position)
        holder.apply {
            bind(subjectsBean!!)
            itemView.tag = subjectsBean
        }
    }

    class Top250AdapterHolder(val binding: ItemIntheaterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Subjects) {
            binding.apply {
                binding.sub = item
                executePendingBindings()
            }
        }

    }
}