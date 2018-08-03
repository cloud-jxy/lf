package com.jocker.jlife.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jocker.jlife.beans.Subjects

class InTheaterDiffItemCallback : DiffUtil.ItemCallback<Subjects>() {
    override fun areItemsTheSame(oldItem: Subjects, newItem: Subjects): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Subjects, newItem: Subjects): Boolean {
        return oldItem == newItem

    }


}