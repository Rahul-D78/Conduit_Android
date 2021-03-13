package com.sih.conduitclone.ui.feed

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sih.conduitclone.R
import com.sih.conduitclone.databinding.ListItemArticleBinding
import io.realworld.api.models.entities.Article
import kotlinx.android.synthetic.main.list_item_article.view.*

class ArticleFeedAdapter: ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
) {
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        return ArticleViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.list_item_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)

            authorTxtView.text = article.author.username
            titleTxtView.text = article.title
            bodyTxtView.text = article.body
            avatarImg.background = ColorDrawable(Color.GRAY)
        }
    }
}