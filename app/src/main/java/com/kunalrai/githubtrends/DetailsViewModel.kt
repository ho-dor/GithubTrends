package com.kunalrai.githubtrends

import android.content.ContextWrapper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pixplicity.easyprefs.library.Prefs

class DetailsViewModel : ViewModel() {

    lateinit var repo_name: String
    lateinit var author: String
    lateinit var language: String
    lateinit var desc: String
    lateinit var stars: String
    lateinit var forks: String
    lateinit var avatar: String

}
