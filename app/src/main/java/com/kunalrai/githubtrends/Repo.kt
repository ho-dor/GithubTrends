package com.kunalrai.githubtrends

import com.squareup.moshi.Json

data class Repo(
    @Json(name = "author")
    var author: String,
    @Json(name = "name")
    var name: String,
    @Json(name = "description")
    var desc: String,
    @Json(name = "avatar")
    var avatar: String,
    @Json(name = "language")
    var language: String,
    @Json(name = "url")
    var url: String,
    @Json(name = "stars")
    var stars: String,
    @Json(name = "forks")
    var forks: String
)