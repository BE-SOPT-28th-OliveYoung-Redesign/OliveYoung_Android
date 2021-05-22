package org.sopt.designclient_oliveyoung.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.designclient_oliveyoung.R
import org.sopt.designclient_oliveyoung.databinding.ItemCosmeticBinding
import kotlin.math.cos

class CosmeticAdapter : RecyclerView.Adapter<CosmeticAdapter.CosmeticViewHolder>() {

    val cosmeticList = mutableListOf<CosmeticData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CosmeticViewHolder {
        val binding = ItemCosmeticBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return CosmeticViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CosmeticViewHolder, position: Int) {
        holder.bind(cosmeticList[position])
    }

    override fun getItemCount(): Int = cosmeticList.size

    class CosmeticViewHolder(val binding : ItemCosmeticBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(cosmeticData: CosmeticData){
                    binding.imageviewCosmetic.setImageResource(cosmeticData.image_cosmetic)
                }
            }
}