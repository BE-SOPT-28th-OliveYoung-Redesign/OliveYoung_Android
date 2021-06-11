package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SelectProductService {
    @GET("/{rank}")
    fun selectProduct(
        @Path("rank") key : Int
    ): Call<List<ResponseProductData>>
}