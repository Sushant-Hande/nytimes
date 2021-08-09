package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nytimes.databinding.ArticleItemBinding
import com.example.nytimes.models.Article

/**
 * Created by shande on 09-08-2021
 */
class ArticleAdapter(private var articleList: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ArticleItemBinding =
            ArticleItemBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    fun addArticles(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

    class ArticleViewHolder(private val itemBinding: ArticleItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(article: Article) {
            itemBinding.tvHeading.text = article.title
            itemBinding.tvReporter.text = article.byline
            itemBinding.executePendingBindings()
        }
    }
}
