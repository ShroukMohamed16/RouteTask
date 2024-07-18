package com.example.domain.repository

import com.example.domain.model.ProductsResponse
import retrofit2.Response

interface MainRepository {
    suspend fun getProducts():Response<ProductsResponse>
}