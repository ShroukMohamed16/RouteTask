package com.example.routetask.view

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.ProductsItem
import com.example.routetask.R
import com.example.routetask.Resources
import com.example.routetask.databinding.ActivityMainBinding
import com.example.routetask.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        mainAdapter = MainAdapter()
        binding.recyclerView.adapter = mainAdapter
        if(isNetworkAvailable())
            getProductsFromApi()
        else
            getProductsFromDataBase()



    }

    override fun onResume() {
        super.onResume()
        binding.searchbar.addTextChangeListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                Log.d("TAG", "beforeTextChanged: ")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.length == 0){
                    getProductsFromDataBase()

                }else {
                    lifecycleScope.launch {
                        mainViewModel.getProductsByName(s.toString()).collect {
                            mainAdapter.submitList(it)

                        }
                    }

                }

            }
            override fun afterTextChanged(s: Editable?) {
                Log.d("TAG", "afterTextChanged: ")


            }

        })
    }
    fun getProductsFromApi(){
        lifecycleScope.launch {
            mainViewModel.getProducts()
            mainViewModel.products.collect{
                when(it) {
                    is Resources.Success -> {
                        mainAdapter.submitList(it.data?.products)
                        mainViewModel.insertProducts(it.data?.products?: listOf<ProductsItem>())
                    }
                    is Resources.Error -> {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_LONG).show()
                        Log.d("TAG", "onCreate: ${it.message}")
                    }
                    else->{
                        Log.d("TAG", "onCreate: Error")}
                }


            }
        }
    }

    fun getProductsFromDataBase(){
        lifecycleScope.launch {
         mainViewModel.getProductsFromDatabase().collect{
             mainAdapter.submitList(it)
         }
        }

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}