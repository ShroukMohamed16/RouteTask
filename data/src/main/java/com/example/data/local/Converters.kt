package com.example.data.local

import androidx.room.TypeConverter
import com.example.domain.model.Dimensions
import com.example.domain.model.Meta
import com.example.domain.model.ProductsItem
import com.example.domain.model.ReviewsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

public object Converters {



    @TypeConverter
    @JvmStatic
        fun fromStringList(value: String?): List<String>? {
            val listType = object : TypeToken<List<String>?>() {}.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        @JvmStatic
        fun fromList(list: List<String>?): String? {
            return Gson().toJson(list)
        }


    @TypeConverter
    @JvmStatic
    fun fromReviewsList(reviews: List<ReviewsItem?>?): String? {
        return Gson().toJson(reviews)
    }

    @TypeConverter
    @JvmStatic
    fun toReviewsList(reviewsString: String?): List<ReviewsItem?>? {
        val listType = object : TypeToken<List<ReviewsItem?>?>() {}.type
        return Gson().fromJson(reviewsString, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromMeta(meta: Meta?): String? {
        return Gson().toJson(meta)
    }

    @TypeConverter
    @JvmStatic
    fun toMeta(metaString: String?): Meta? {
        return Gson().fromJson(metaString, Meta::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun fromDimensions(dimensions: Dimensions?): String? {
        return Gson().toJson(dimensions)
    }

    @TypeConverter
    @JvmStatic
    fun toDimensions(dimensionsString: String?): Dimensions? {
        return Gson().fromJson(dimensionsString, Dimensions::class.java)
    }


}