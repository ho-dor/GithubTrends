package com.kunalrai.githubtrends

import android.content.ContextWrapper
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kunalrai.githubtrends.databinding.DetailsFragmentBinding
import com.kunalrai.githubtrends.databinding.ListFragmentBinding
import com.pixplicity.easyprefs.library.Prefs


class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private val viewModel: DetailsViewModel by lazy {
        ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner

        binding.viewmodel = viewModel
        setHasOptionsMenu(true)

        Prefs.Builder()
            .setContext(context)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName("trending")
            .setUseDefaultSharedPreference(true)
            .build()

        viewModel.repo_name = Prefs.getString("name", "N/A")
        viewModel.author = Prefs.getString("author", "N/A")
        viewModel.desc = Prefs.getString("desc", "N/A")
        viewModel.language = Prefs.getString("language", "N/A")
        viewModel.stars = Prefs.getString("stars", "N/A")
        viewModel.forks = Prefs.getString("forks", "N/A")
        viewModel.avatar = Prefs.getString("avatar","")

        Glide.with(context!!).load(viewModel.avatar)
            .apply(RequestOptions().centerCrop())
            .into(binding.ownerImageDetails)

        return binding.root
    }

}
