package com.sih.conduitclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sih.conduitclone.databinding.FragmentFeedBinding

class GlobalFeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentFeedBinding.inflate(inflater, container,false)

        _binding?.fetchFeedButton?.setOnClickListener {
            viewModel.fetchGlobalFeed()
        }
        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()

        //For memory leak
        _binding = null
    }
}