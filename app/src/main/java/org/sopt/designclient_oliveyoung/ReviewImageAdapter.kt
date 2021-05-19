package org.sopt.designclient_oliveyoung


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import org.sopt.designclient_oliveyoung.databinding.ItemReviewImageBinding

class ReviewImageAdapter : RecyclerView.Adapter<ReviewImageAdapter.ReviewImageViewHolder>() {
    private val reviewImgDrawables =
        arrayOf<Int>(R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_5)

    class ReviewImageViewHolder(private val binding: ItemReviewImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(targetDrawable: Int) {
            binding.imgReviewItem.setImageDrawable(
                getDrawable(
                    binding.imgReviewItem.context,
                    targetDrawable
                )
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewImageViewHolder {
        val binding =
            ItemReviewImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewImageViewHolder, position: Int) {
        holder.onBind(reviewImgDrawables[position])
    }

    override fun getItemCount(): Int = reviewImgDrawables.size
}