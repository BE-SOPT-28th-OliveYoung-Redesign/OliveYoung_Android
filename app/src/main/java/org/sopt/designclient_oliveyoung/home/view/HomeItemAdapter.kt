package org.sopt.designclient_oliveyoung.home.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.designclient_oliveyoung.R
import org.sopt.designclient_oliveyoung.databinding.ItemRankingBinding
import org.sopt.designclient_oliveyoung.review.ReviewActivity

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
        when (position) {
            0 -> holder.bind("")
            else -> holder.bind(items[position - 1])
        }
    }

    override fun getItemCount(): Int = items.size + 1

    class HomeItemViewHolder(private val binding: ItemRankingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            if (item is RankingResponse.Data) {
                binding.item = item
                Glide.with(binding.imgItemRanking.context).load(item.mainImageView)
                    .into(binding.imgItemRanking)
                binding.root.setOnClickListener {
                    val intent = Intent(binding.root.context, ReviewActivity::class.java).apply {
                        putExtra("itemRank", item.rank)
                    }
                    startActivity(binding.root.context, intent, null)
                }
            } else {
                binding.apply {
                    imgItemRanking.setImageResource(R.drawable.banner1)
                    constraintlayoutItemRanking.visibility = android.view.View.GONE
                }
            }
        }
    }
}