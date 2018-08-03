package com.jocker.jlife.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jocker.jlife.beans.Subjects
import com.jocker.jlife.databinding.ItemIntheaterBinding
import com.jocker.jlife.ui.main.MovieListFragmentDirections

class InTheaterAdapter
    : ListAdapter<Subjects, InTheaterAdapter.ViewHolder>(InTheaterDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = ItemIntheaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject = getItem(position)
        val inTheaterClick = InTheaterClick(subject.id)
        holder.apply {
            bind(subject, inTheaterClick)
            itemView.tag = subject
        }
    }

    class InTheaterClick constructor(private val id: Long) : View.OnClickListener {
        override fun onClick(view: View?) {
            if (view != null) {
                val afDirection = MovieListFragmentDirections.actionMainFragmentToInTheaterDetailFragment()
                afDirection.setId(id.toInt())
                Navigation.findNavController(view).navigate(afDirection)
            }
        }

    }

    class ViewHolder(private val binding: ItemIntheaterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(subject: Subjects, inTheaterClick: InTheaterClick) {
            binding.apply {
                sub = subject
                click = inTheaterClick
                executePendingBindings()
            }
        }

    }
}