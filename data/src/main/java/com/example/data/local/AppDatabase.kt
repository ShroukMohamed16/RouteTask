package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.example.domain.model.ProductsItem


@Database(
    entities = [ProductsItem::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Products.db"
    }


    abstract fun productsDao(): Dao





}