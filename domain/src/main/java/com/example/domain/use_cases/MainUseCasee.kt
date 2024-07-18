package com.example.domain.use_cases

import com.example.domain.model.ProductsItem
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainUseCasee @Inject constructor(private val mainRepository: MainRepository) {
    suspend  fun getProducts() = mainRepository.getProducts()
    fun getProductsFromDatabase() = mainRepository.getProductsFromDatabase()
    fun insertProducts(productsItem: List<ProductsItem?>?) = mainRepository.insertProducts(productsItem)
}