package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductsResponse(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("skip")
    val skip: Int? = null,

    @field:SerializedName("products")
    val products: List<ProductsItem?>? = null
) : Parcelable

@Parcelize
data class ReviewsItem(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("reviewerName")
    val reviewerName: String? = null,

    @field:SerializedName("reviewerEmail")
    val reviewerEmail: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("comment")
    val comment: String? = null
) : Parcelable

@Parcelize
data class Dimensions(

    @field:SerializedName("depth")
    val depth: String? = null,

    @field:SerializedName("width")
    val width: String? = null,

    @field:SerializedName("height")
    val height: String? = null
) : Parcelable

@Parcelize
data class ProductsItem(

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = null,

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("returnPolicy")
    val returnPolicy: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("weight")
    val weight: Int? = null,

    @field:SerializedName("warrantyInformation")
    val warrantyInformation: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null,

    @field:SerializedName("discountPercentage")
    val discountPercentage: String? = null,

    @field:SerializedName("reviews")
    val reviews: List<ReviewsItem?>? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("shippingInformation")
    val shippingInformation: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("availabilityStatus")
    val availabilityStatus: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("stock")
    val stock: Int? = null,

    @field:SerializedName("sku")
    val sku: String? = null,

    @field:SerializedName("dimensions")
    val dimensions: Dimensions? = null,

    @field:SerializedName("brand")
    val brand: String? = null
) : Parcelable

@Parcelize
data class Meta(

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("qrCode")
    val qrCode: String? = null,

    @field:SerializedName("barcode")
    val barcode: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable
