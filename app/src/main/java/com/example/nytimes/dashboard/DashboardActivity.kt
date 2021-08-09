package com.example.nytimes.dashboard

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.ArticleAdapter
import com.example.nytimes.R
import com.example.nytimes.databinding.DashboardActivityBinding
import com.example.nytimes.network.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    lateinit var binding: DashboardActivityBinding
    private val viewModel: DashboardViewModel by viewModels()
    lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.dashboard_activity)
        adapter = ArticleAdapter(listOf())
        binding.rvArticles.adapter = adapter
        binding.rvArticles.layoutManager = LinearLayoutManager(this)
        observeViewModel()
    }

    private fun observeViewModel() {

        if (isOnline()) {
            viewModel.getMostViewedArticles().observe(this) { resource ->

                when (resource.status) {

                    Status.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.progressBar.animate()
                    }

                    Status.Success -> {
                        binding.progressBar.isVisible = false
                        resource.data?.results?.let { articles ->
                            adapter.addArticles(articles)
                        }
                    }

                    Status.Error -> {
                        binding.progressBar.isVisible = false
                    }

                }

            }
        }

    }

    fun isOnline(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
        return false
    }

}