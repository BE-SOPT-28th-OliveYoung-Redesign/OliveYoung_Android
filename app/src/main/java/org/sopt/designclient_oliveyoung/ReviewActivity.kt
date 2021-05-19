package org.sopt.designclient_oliveyoung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import org.sopt.designclient_oliveyoung.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val reviewerPropertiesChipGroup: ChipGroup = binding.chipGroupReviewerProperties
        val reviewerProperties = arrayOf("복합성", "쿨톤", "각질", "모공")
        for (i in reviewerProperties) {
            val newChip = Chip(this@ReviewActivity)
            newChip.text = i
            newChip.setTextColor(resources.getColor((R.color.mint)))
            newChip.setChipBackgroundColorResource(R.color.white)
            newChip.setChipStrokeColorResource(R.color.mint)
            newChip.setChipStrokeWidthResource(R.dimen.chip_stroke_width)
            reviewerPropertiesChipGroup.addView(newChip)
        }
        val reviewImageAdapter = ReviewImageAdapter()
        val reviewImageLayoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        binding.recyclerViewImgs.adapter = reviewImageAdapter
        binding.recyclerViewImgs.layoutManager = reviewImageLayoutManager
    }
}