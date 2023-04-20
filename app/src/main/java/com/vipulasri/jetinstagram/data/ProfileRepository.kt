package com.vipulasri.jetinstagram.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.vipulasri.jetinstagram.model.*

object ProfileRepository {

    private val highlights = mutableStateOf<List<Highlights>>(emptyList())
    private val posts = mutableStateOf<List<ProfilePosts>>(emptyList())

    private fun populateHighlights() {

        val _highlights = ArrayList<Highlights>()

        (0..8).forEach { index ->
            val highlight = Highlights(
                image = "https://source.unsplash.com/random/400x300?${index + 1}",
                name = highlightsName[index]
            )
            _highlights.add(highlight)
        }

        highlights.value = _highlights
    }

    init {
        populateHighlights()
    }

    fun observeHighlights(): MutableState<List<Highlights>> = highlights

    private fun populatePosts() {

        val _posts = ArrayList<ProfilePosts>()

        (0..29).forEach { index ->
            val profilePost = ProfilePosts(
                image = "https://source.unsplash.com/random/400x300?${index + 1}",
            )
            _posts.add(profilePost)
        }

        posts.value = _posts
    }

    init {
        populatePosts()
    }

    fun observeProfilePosts(): MutableState<List<ProfilePosts>> = posts
}