package com.example.routetask

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ProductsItem
import com.example.routetask.databinding.ProductItemBinding

class MainAdapter :ListAdapter<ProductsItem,ProductViewHolder>(ProductDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class ProductDiffUtil:DiffUtil.ItemCallback<ProductsItem>(){
    override fun areItemsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
        return oldItem === newItem

    }

    override fun areContentsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
        return oldItem == newItem
    }

}

class ProductViewHolder(private val productItemBinding: ProductItemBinding):RecyclerView.ViewHolder(productItemBinding.root){}