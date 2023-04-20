package com.vipulasri.jetinstagram.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.vipulasri.jetinstagram.model.Favourite
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.model.names
import com.vipulasri.jetinstagram.model.usernames

object FavouriteRepository {

    private val _favs = mutableStateOf<List<Favourite>>(emptyList())
    val favs: State<List<Favourite>> = _favs

    private fun populateFavourite() {
        val favs = ArrayList<Favourite>()
        (0..11).forEach { index ->
            val fav = Favourite(
                id = index + 1,
                user = User(
                    name = names[index],
                    username = usernames[index],
                    image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg",
                    postsCount = 123,
                    followersCount = "9.2K",
                    followingCount = "1.3K"
                )
            )
            favs.add(fav)
        }

        this._favs.value = favs
    }

    init {
        populateFavourite()
    }

}