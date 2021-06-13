package org.sopt.designclient_oliveyoung.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import org.sopt.designclient_oliveyoung.databinding.ActivityHomeBinding
import org.sopt.designclient_oliveyoung.review.ReviewActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class HomeActivity : AppCompatActivity() {
    companion object {
        const val BaseUrl = "http://3.34.183.244:5000/api/"
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tablayoutHomeCategory.apply {
            addTab(this.newTab().setText("홈"))
            addTab(this.newTab().setText("오특"))
            addTab(this.newTab().setText("신상"))
            addTab(this.newTab().setText("랭킹"))
            addTab(this.newTab().setText("기획전"))
            addTab(this.newTab().setText("이벤트"))
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val retrofit: Retrofit? = Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service = retrofit?.create(RankingItemService::class.java)
        val call = service?.getRankingItem()
        call?.enqueue(object : Callback<List<RankingResponse.Data>> {
            override fun onResponse(
                call: Call<List<RankingResponse.Data>>,
                response: Response<List<RankingResponse.Data>>
            ) {
                Log.d("태그", response.body().toString())
                val items = response.body()!!
                binding.recyclerviewRanking.adapter = HomeItemAdapter(items)
            }

            override fun onFailure(call: Call<List<RankingResponse.Data>>, t: Throwable) {
                Log.d("태그", "network failed by\n$t")
            }
        })
    }

    interface RankingItemService {
        @GET("list")
        fun getRankingItem(): Call<List<RankingResponse.Data>>
    }
}