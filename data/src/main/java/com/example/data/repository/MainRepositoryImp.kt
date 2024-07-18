package com.example.data.repository

import com.example.data.local.Dao
import com.example.data.remote.ApiService
import com.example.domain.model.ProductsItem
import com.example.domain.model.ProductsResponse
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImp @Inject constructor(private val apiService: ApiService,
    private val dao: Dao):MainRepository {
    override suspend fun getProducts(): Response<ProductsResponse>{
    return apiService.getProducts()
}

    override fun getProductsFromDatabase(): Flow<List<ProductsItem>> {
       return dao.getProducts()
    }

    override fun insertProducts(productsItem: List<ProductsItem?>?) {
        dao.insertProducts(productsItem)
    }

    override fun getProductsByName(name: String): Flow<List<ProductsItem>> {
       return dao.searchByName(name)
    }
}