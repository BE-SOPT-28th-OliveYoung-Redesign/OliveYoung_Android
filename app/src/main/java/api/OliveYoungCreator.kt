package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OliveYoungCreator {
    private const val BASE_URL = "http://15.164.163.178:5000/api/list"

    private val retrofit: Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val SELECT_PRODUCT_SERVICE: SelectProductService= retrofit.create(api.SelectProductService::class.java)
}