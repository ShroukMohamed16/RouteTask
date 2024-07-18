package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao{

    @Query("select * from Products")
    fun getProducts(): Flow<List<ProductsItem>>

    @Query("select * from Products where LTRIM(RTRIM(title)) LIKE '%' || :data || '%' ")
    fun searchByName(data:String): Flow<List<ProductsItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertProducts(productsItem: List<ProductsItem?>?)


}