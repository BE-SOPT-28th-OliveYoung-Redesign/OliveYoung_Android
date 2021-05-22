package org.sopt.designclient_oliveyoung.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.sopt.designclient_oliveyoung.databinding.ActivityHomeBinding
import org.sopt.designclient_oliveyoung.review.ReviewActivity


class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showCosmeticItemReview()

        binding.tablayoutHomeCategory.apply {
            addTab(this.newTab().setText("홈"))
            addTab(this.newTab().setText("오특"))
            addTab(this.newTab().setText("신상"))
            addTab(this.newTab().setText("랭킹"))
            addTab(this.newTab().setText("기획전"))
            addTab(this.newTab().setText("이벤트"))

        }
    }

    fun showCosmeticItemReview(){
        binding.imageviewItemFirst.setOnClickListener (this)
        binding.imageviewItemTwo.setOnClickListener (this)
        binding.imageviewItemThird.setOnClickListener (this)
        binding.imageviewItemFourth.setOnClickListener (this)
        binding.imageviewItemFive.setOnClickListener (this)



    }

    override fun onClick(view: View?) {
        when (view!!){
            binding.imageviewItemFirst -> {
                val intent = Intent(this@HomeActivity,ReviewActivity::class.java)
                startActivity(intent)
            }
            binding.imageviewItemTwo -> {
                val intent = Intent(this@HomeActivity,ReviewActivity::class.java)
                startActivity(intent)
            }
            binding.imageviewItemThird -> {
                val intent = Intent(this@HomeActivity,ReviewActivity::class.java)
                startActivity(intent)
            }
            binding.imageviewItemFourth -> {
                val intent = Intent(this@HomeActivity,ReviewActivity::class.java)
                startActivity(intent)
            }
            binding.imageviewItemFive -> {
                val intent = Intent(this@HomeActivity,ReviewActivity::class.java)
                startActivity(intent)
            }

        }
    }

}