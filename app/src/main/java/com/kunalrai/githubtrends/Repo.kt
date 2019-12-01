package com.kunalrai.githubtrends

import com.squareup.moshi.Json

data class Repo(
    @Json(name = "author")
    var author: String = "N/A",
    @Json(name = "name")
    var name: String = "N/A",
    @Json(name = "description")
    var desc: String = "N/A",
    @Json(name = "avatar")
    var avatar: String = "N/A",
    @Json(name = "language")
    var language: String = "N/A",
    @Json(name = "url")
    var url: String = "N/A",
    @Json(name = "stars")
    var stars: String = "N/A",
    @Json(name = "forks")
    var forks: String = "N/A"
)