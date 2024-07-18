package com.example.domain.use_cases

import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainUseCasee @Inject constructor(private val mainRepository: MainRepository) {
    suspend operator fun invoke() = mainRepository.getProducts()
}