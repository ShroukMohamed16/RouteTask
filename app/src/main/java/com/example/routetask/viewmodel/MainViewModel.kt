package com.example.routetask.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ProductsResponse
import com.example.domain.use_cases.MainUseCasee
import com.example.routetask.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(val mainUseCasee: MainUseCasee):ViewModel() {

    // paid bills
    private val _products = MutableStateFlow<Resources<ProductsResponse>>(Resources.Ideal())
    val products = _products.asStateFlow()

    private val errorHandlerException = CoroutineExceptionHandler { _, t ->
        viewModelScope.launch {
            _products.emit(Resources.Error(t.message.toString()))
        }
    }

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
    }
    suspend fun getProducts() {
        runBlocking {
            _products.emit(Resources.Loading())
        }
        try {
            viewModelScope.launch(errorHandlerException) {
                val result = mainUseCasee.invoke()
                if (result.isSuccessful) {
                    _products.emit(Resources.Success(result.body()))
                } else {
                    when (result.code()) {
                        500 -> {
                            _products.emit(Resources.Error("هناك مشكلة في الاتصال بالسيرفر قم بالاتصال بمدير النظام!"))
                            Log.d("TAG", "getProducts: ${result.message()}")

                        }
                        else -> {
                            _products.emit(Resources.Error(result.message()))
                          //  Log.d(TAG, "postPaidBills: ${result.message()}")

                        }
                    }
                }
            }
        } catch (e: Exception) {
            viewModelScope.launch {
                _products.emit(Resources.Error("حدثت مشكلة رجاء حاول مرة أخري "))
            }

        }
    }
}