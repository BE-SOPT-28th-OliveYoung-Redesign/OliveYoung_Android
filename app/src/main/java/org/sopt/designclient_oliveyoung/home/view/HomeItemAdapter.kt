package org.sopt.designclient_oliveyoung.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.designclient_oliveyoung.databinding.ItemRankingBinding

class HomeItemAdapter(private val items: List<RankingResponse.Data>) :
    RecyclerView.Adapter<HomeItemAdapter.HomeItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeItemViewHolder {
        val binding = ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class HomeItemViewHolder(private val binding: ItemRankingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            if (item is RankingResponse.Data) {
                binding.item = item
                Glide.with(binding.imgItemRanking.context).load(item.mainImageView)
                    .into(binding.imgItemRanking)
            }
        }
    }
}