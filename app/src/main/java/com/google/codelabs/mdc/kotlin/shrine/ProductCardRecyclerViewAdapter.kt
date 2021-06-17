package com.google.codelabs.mdc.kotlin.shrine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.codelabs.mdc.kotlin.shrine.databinding.ShrProductCardBinding

import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry

/**
 * Adapter used to show a simple grid of products.
 */
class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) : RecyclerView.Adapter<ProductCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val binding = DataBindingUtil.inflate<ShrProductCardBinding>(LayoutInflater.from(parent.context),R.layout.shr_product_card,parent,false)
        return ProductCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if (position < productList.size) {
            holder.bind(productList[position])
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
