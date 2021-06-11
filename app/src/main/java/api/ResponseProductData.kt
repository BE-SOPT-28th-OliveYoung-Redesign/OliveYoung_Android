package api

import com.google.gson.annotations.SerializedName

data class ResponseProductData(
    val success:Boolean,
    val message:String,
    val data:ProductData?
)

data class ProductData(
    var listLabel:String,
    var mainImageView:String,
    var brandLabel:String,
    var rank:Int
)