package com.example.routetask.view

import android.os.Bundle
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
import kotlinx.coroutines.*


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

        lifecycleScope.launch {
            mainViewModel.getProducts()
            mainViewModel.products.collect{
                when(it) {
                    is Resources.Success -> mainAdapter.submitList(it.data?.products)
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
}