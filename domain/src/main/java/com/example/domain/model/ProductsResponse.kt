package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Parcelize

data class ProductsResponse(

    @field:SerializedName("total")
    var total: Int? = null,

    @field:SerializedName("limit")
    var limit: Int? = null,

    @field:SerializedName("skip")
    var skip: Int? = null,

    @field:SerializedName("products")
    var products: List<ProductsItem?>? = null
) : Parcelable

@Parcelize
data class ReviewsItem(

    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("reviewerName")
    var reviewerName: String? = null,

    @field:SerializedName("reviewerEmail")
    var reviewerEmail: String? = null,

    @field:SerializedName("rating")
    var rating: Int? = null,

    @field:SerializedName("comment")
    var comment: String? = null
) : Parcelable

@Parcelize
data class Dimensions(

    @field:SerializedName("depth")
    var depth: String? = null,

    @field:SerializedName("width")
    var width: String? = null,

    @field:SerializedName("height")
    var height: String? = null
) : Parcelable

@Parcelize
@Entity(tableName = "Products")
data class ProductsItem(

    @field:SerializedName("images")
    var images: List<String?>? = null,

    @field:SerializedName("thumbnail")
    var thumbnail: String? = null,

    @field:SerializedName("minimumOrderQuantity")
    var minimumOrderQuantity: Int? = null,

    @field:SerializedName("rating")
    var rating: String? = null,

    @field:SerializedName("returnPolicy")
    var returnPolicy: String? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("weight")
    var weight: Int? = null,

    @field:SerializedName("warrantyInformation")
    var warrantyInformation: String? = null,

    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("tags")
    var tags: List<String?>? = null,

    @field:SerializedName("discountPercentage")
    var discountPercentage: String? = null,

    @field:SerializedName("reviews")
    var reviews: List<ReviewsItem?>? = null,

    @field:SerializedName("price")
    var price: String? = null,

    @field:SerializedName("meta")
    var meta: Meta? = null,

    @field:SerializedName("shippingInformation")
    var shippingInformation: String? = null,

    @field:SerializedName("id")
    @PrimaryKey
    var id: Int? = null,

    @field:SerializedName("availabilityStatus")
    var availabilityStatus: String? = null,

    @field:SerializedName("category")
    var category: String? = null,

    @field:SerializedName("stock")
    var stock: Int? = null,

    @field:SerializedName("sku")
    var sku: String? = null,

    @field:SerializedName("dimensions")
    var dimensions: Dimensions? = null,

    @field:SerializedName("brand")
    var brand: String? = null
) : Parcelable

@Parcelize
data class Meta(

    @field:SerializedName("createdAt")
    var createdAt: String? = null,

    @field:SerializedName("qrCode")
    var qrCode: String? = null,

    @field:SerializedName("barcode")
    var barcode: String? = null,

    @field:SerializedName("updatedAt")
    var updatedAt: String? = null
) : Parcelable
