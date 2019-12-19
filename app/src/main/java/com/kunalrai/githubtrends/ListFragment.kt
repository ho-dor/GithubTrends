package com.kunalrai.githubtrends

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import com.kunalrai.githubtrends.databinding.ListFragmentBinding


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    private lateinit var binding: ListFragmentBinding
    lateinit var listAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner

        binding.viewmodel = viewModel

        listAdapter = ListAdapter(context)

        binding.rvRepoList?.let{
            it.layoutManager = LinearLayoutManager(context)
            it.setHasFixedSize(true)
            it.adapter = listAdapter //we add the adapter here
        }

        binding.shimmerViewContainer.startShimmer()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshData()
        binding.swipeRefresh.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            refreshData()
        })
    }


    fun refreshData() {
        viewModel.getRepos().observe(this,
            Observer<List<Repo>> {
                it?.let { repoList ->
                    Log.i("data",""+repoList.size)
                    listAdapter.swapData(repoList)
                    binding.swipeRefresh.isRefreshing = false
                    binding.shimmerViewContainer.stopShimmer()
                    binding.shimmerViewContainer.visibility = View.GONE
                }
            })
    }

    override fun onPause() {
        super.onPause()
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
    }

}
