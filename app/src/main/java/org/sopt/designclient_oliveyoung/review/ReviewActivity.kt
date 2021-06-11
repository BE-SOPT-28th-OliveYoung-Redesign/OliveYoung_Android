package org.sopt.designclient_oliveyoung.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import api.OliveYoungCreator
import api.ResponseProductData
import api.SelectProductService
import org.sopt.designclient_oliveyoung.R
import org.sopt.designclient_oliveyoung.databinding.ActivityReviewBinding
import org.sopt.designclient_oliveyoung.home.view.HomeActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    private lateinit var cosmeticAdapter: CosmeticAdapter
    private val viewModel by viewModels<ReviewViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        startCosmeticAdapter()
        returnMainActivity()
        updateLikeCounts()

      val call: Call<ResponseProductData> = OliveYoungCreator.SELECT_PRODUCT_SERVICE
          .selectProduct(key = )

        call.enqueue(object : Callback<ResponseProductData>{
            override fun onResponse(
                call: Call<ResponseProductData>,
                response: Response<ResponseProductData>
            ) {
                if(response.isSuccessful){
                    val URL=response.ProductData?.mainImageView
                    val listLabel=response.Product?.listLabel
                    val brandLabel=response.Product?.brandLabel
                }
            }

            override fun onFailure(call: Call<ResponseProductData>, t: Throwable) {
               Log.d("NetworkTest", "error:$t")
            }

        })
    }


    fun startCosmeticAdapter(){
        cosmeticAdapter = CosmeticAdapter()
        binding.recyclerviewProduct.adapter = cosmeticAdapter

        cosmeticAdapter.cosmeticList.addAll(
                mutableListOf(
                        CosmeticData(
                                image_cosmetic = R.drawable.cos_one
                        ),
                        CosmeticData(
                                image_cosmetic = R.drawable.cos_two
                        ),
                        CosmeticData(
                                image_cosmetic = R.drawable.cos_three
                        ),
                        CosmeticData(
                                image_cosmetic = R.drawable.cos_one
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

    fun updateLikeCounts(){
        binding.imgaebuttonHelpReview.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                viewModel.plusLikeCount()
            } else {
                viewModel.minusLikeCount()
            }
        }
    }


}