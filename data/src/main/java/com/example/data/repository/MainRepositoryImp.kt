package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.model.ProductsResponse
import com.example.domain.repository.MainRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImp @Inject constructor(private val apiService: ApiService):MainRepository {
    override suspend fun getProducts(): Response<ProductsResponse>{
    return apiService.getProducts()
}
}