package com.kunalrai.githubtrends

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.kunalrai.githubtrends.databinding.ListFragmentBinding


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    private lateinit var binding: ListFragmentBinding
    //private lateinit var dataList: List<Repo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)

        binding.viewmodel = viewModel
        setHasOptionsMenu(true)

        return binding.root
    }

}
