package com.kunalrai.githubtrends

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kunalrai.githubtrends.databinding.ListFragmentBinding


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    private lateinit var binding: ListFragmentBinding
    var recyclerView: RecyclerView? = null
    lateinit var listAdapter: ListAdapter
    var repoList: List<Repo>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRepos().observe(this,
            Observer<List<Repo>> {
                it?.let { repoList ->
                    listAdapter = ListAdapter(context, repoList)
                    recyclerView?.adapter = listAdapter
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner

        binding.viewmodel = viewModel
        setHasOptionsMenu(true)

        recyclerView = view?.findViewById(R.id.rv_repo_list)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.setHasFixedSize(true)


        return binding.root
    }

}
