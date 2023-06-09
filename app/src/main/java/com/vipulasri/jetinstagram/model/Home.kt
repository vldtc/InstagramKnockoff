package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch",
    "vladutc",
    "adamm"
)
val usernames = arrayOf(
    "Store Ezekiel",
    "Niany Chan",
    "Opiok Earl",
    "Ashok Email",
    "Dark Emeralds",
    "Bedta Neil",
    "Shrish Hirsh",
    "Matdo Madi",
    "Phill Sohn",
    "Deitch Mitch",
    "Vladut Cirlan",
    "Adam Mukkarim"
)

val places = arrayOf(
    "London-Tower Bridge",
    "Madame Tussad-London",
    "London Eye-London",
    "Covent Garden",
    "London Bridge",
    "East India",
    "East Ham",
    "Search"
)

val songs = arrayOf(
    "Happy Moments-Inod",
    "Beautiful Day-Jonathan Roy",
    "One Kiss-Dua Lipa",
    "Despasito-Luis Fonsi",
    "People-Libianca",
    "Calm Down-Rema",
)