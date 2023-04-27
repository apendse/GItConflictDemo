package com.aap.git.conflict.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.aap.git.conflict.demo.databinding.RowBinding

class Callback : DiffUtil.ItemCallback<Element>() {
    override fun areItemsTheSame(oldItem: Element, newItem: Element) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Element, newItem: Element) = areItemsTheSame(oldItem, newItem)
}

class ElementAdapter: ListAdapter<Element, ElementViewHolder>(Callback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val binding = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val element = getItem(position)
        with(holder.binding) {
            symbol.text = element.symbol
            name.text = element.familiarName
            atomicNumber.text = element.atomicNumber.toString()
        }
    }

}

class ElementViewHolder(val binding: RowBinding) : ViewHolder(binding.root)