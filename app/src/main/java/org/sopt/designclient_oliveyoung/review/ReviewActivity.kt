package org.sopt.designclient_oliveyoung.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.designclient_oliveyoung.databinding.ActivityReviewBinding
import org.sopt.designclient_oliveyoung.home.HomeActivity

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    private lateinit var cosmeticAdapter: CosmeticAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startCosmeticAdapter()
        returnMainActivity()
    }

    fun startCosmeticAdapter(){
        cosmeticAdapter = CosmeticAdapter()
        binding.recyclerviewProduct.adapter = cosmeticAdapter

        cosmeticAdapter.cosmeticList.addAll(
                mutableListOf<CosmeticData>(
                        CosmeticData(
                                image_cosmetic = "@drawable/cos_one"
                        ),
                        CosmeticData(
                                image_cosmetic = "@drawable/cos_two"
                        ),
                        CosmeticData(
                                image_cosmetic = "@drawable/cos_three"
                        ),
                        CosmeticData(
                                image_cosmetic = "@drawable/cos_one"
                        )
                )
        )
        cosmeticAdapter.notifyDataSetChanged()
    }

    fun returnMainActivity(){
        binding.imageviewBackHome.setOnClickListener {
            val intent = Intent(this@ReviewActivity , HomeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }


}