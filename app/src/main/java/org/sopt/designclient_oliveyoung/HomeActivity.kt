package org.sopt.designclient_oliveyoung

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.designclient_oliveyoung.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    var flag=0;
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bar1.setOnClickListener {
            if(flag==0)
            {
                binding.bar1.setTextColor(Color.parseColor("#e27a74"))
                flag++;
            }
        }
    }
}