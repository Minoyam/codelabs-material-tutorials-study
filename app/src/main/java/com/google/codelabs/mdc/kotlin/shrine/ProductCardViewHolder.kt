package com.google.codelabs.mdc.kotlin.shrine

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.codelabs.mdc.kotlin.shrine.databinding.ShrProductCardBinding
import com.google.codelabs.mdc.kotlin.shrine.network.ImageRequester.setImageFromUrl
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry

class ProductCardViewHolder(private val binding: ShrProductCardBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ProductEntry) {
        binding.run {
            productTitle.text = item.title
            productPrice.text = item.price
            setImageFromUrl(productImage, item.url)
        }
    }
}
