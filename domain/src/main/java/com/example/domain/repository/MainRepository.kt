package com.example.domain.repository

import com.example.domain.model.ProductsItem
import com.example.domain.model.ProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MainRepository {
    suspend fun getProducts():Response<ProductsResponse>
    fun getProductsFromDatabase(): Flow<List<ProductsItem>>
    fun insertProducts(productsItem: List<ProductsItem?>?)
}