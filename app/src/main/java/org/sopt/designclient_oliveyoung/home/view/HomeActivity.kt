package org.sopt.designclient_oliveyoung.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.sopt.designclient_oliveyoung.databinding.ActivityHomeBinding
import org.sopt.designclient_oliveyoung.review.ReviewActivity


class HomeActivity : AppCompatActivity() {
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
        val testItems = listOf<RankingResponse.Data>(
            RankingResponse.Data(
                "60bc69e2af62b1dbc7d41a4e",
                4,
                "페리페라",
                "올테이크팔레트",
                "https://soptseminar5test.s3.ap-northeast-2.amazonaws.com/rank4_picture.png",
                "이 제품은 4등 제품입니다."
            ),
            RankingResponse.Data(
                "60bc6a05af62b1dbc7d41a4f",
                5,
                "니들리",
                "데일리 토너 패드",
                "https://soptseminar5test.s3.ap-northeast-2.amazonaws.com/rank5_picture.png",
                "이 제품은 5등 제품입니다."
            )
        )
        binding.recyclerviewRanking.adapter = HomeItemAdapter(testItems)
    }
}