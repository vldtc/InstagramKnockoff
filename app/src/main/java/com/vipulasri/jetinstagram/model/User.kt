package com.vipulasri.jetinstagram.model

data class User(
  val name: String,
  val username: String,
  val image: String,
  val postsCount: Int,
  val followersCount: String,
  val followingCount: String
)

val currentUser = User(
    name = "Vipul Asri",
    username = "vipulasri",
    image = "https://s.gravatar.com/avatar/62a968f41c1feb83fd1cd142e7c043f3?s=200",
    postsCount = 123,
    followersCount = "9.2K",
    followingCount = "1.3K"
)

