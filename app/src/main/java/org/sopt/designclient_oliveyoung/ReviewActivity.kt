package org.sopt.designclient_oliveyoung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        val reviewerPropertiesChipGroup : ChipGroup = findViewById(R.id.chip_group_reviewer_properties)
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
    }
}