package com.example.routetask.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ProductsItem
import com.example.routetask.R
import com.example.routetask.databinding.ProductItemBinding

class MainAdapter :ListAdapter<ProductsItem, ProductViewHolder>(ProductDiffUtil()){

    private lateinit var binding:ProductItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.product_item,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentObj = getItem(position)
        binding.product = currentObj
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

class ProductViewHolder(productItemBinding: ProductItemBinding):RecyclerView.ViewHolder(productItemBinding.root)