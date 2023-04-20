package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.data.ProfileRepository
import com.vipulasri.jetinstagram.model.Highlights
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.components.icon

@Composable
fun Profile(){

    Scaffold(
        topBar = { Toolbar() }
    ){
        val highlights by ProfileRepository.observeHighlights()
        Column {
            LazyColumn{
                item {
                    ProfileData()
                    ProfileInfo()
                    ButtonRow()
                    HighlightsSection(highlights)
                    PostsTypeSection()
                }
            }
            ProfilePostsSection()
        }

    }
}

@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            modifier = Modifier.icon(),
            contentDescription = null
        )
        Text(
            text = "${currentUser.username}",
            fontWeight = FontWeight.Bold
        )
        Icon(
            Icons.Default.MoreVert,
            modifier = Modifier.icon(),
            contentDescription = null
        )
    }
}

@Composable
fun ProfileData(
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfilePic(
            imageUrl = "${currentUser.image}",
            Modifier
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.CenterVertically)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${ currentUser.postsCount}",
                fontWeight = FontWeight.Bold
            )
            Text(text = "Posts")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.CenterVertically)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${ currentUser.followersCount}",
                fontWeight = FontWeight.Bold
            )
            Text(text = "Followers")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.CenterVertically)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${ currentUser.followingCount}",
                fontWeight = FontWeight.Bold
                )
            Text(text = "Following")
        }
    }
}

@Composable
fun ProfileInfo(
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 10.dp, vertical = 5.dp),

    ) {
        Text(
            text = "${currentUser.name}",
            fontWeight = FontWeight.Bold
            )
        Text(text = "lorem Ipsum for life")
    }
}

@Composable
fun ButtonRow(
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
            ){
        Button(
            onClick = {},
            modifier = Modifier
                .weight(2.5f)
                .padding(start = 10.dp)
                .background(color = Color(0xFF00A7E9))
        ) {
            Text(
                text = "Follow"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .weight(2.5f)
                .padding(start = 10.dp)
                .background(color = Color(0xFFD1D1D1))
        ) {
            Text(
                text = "Message"
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
                .background(color = Color(0xFFD1D1D1))
        ) {
            Icon(imageVector = Icons.Default.Person , contentDescription = "")
        }
    }
}

@Composable
private fun HighlightsSection(highlights: List<Highlights>){
    Column {
        HighlightsList(highlights)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun HighlightsList(highlights: List<Highlights>) {
    LazyRow {
        itemsIndexed(highlights) { index, highlight ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)
            ) {
                HighlightImage(
                    imageUrl = highlight.image, weight = Modifier
                        .weight(1f)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(highlight.name, style = MaterialTheme.typography.caption)
            }

            if (index == highlights.size.minus(1)) {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}

@Composable
fun PostsTypeSection(
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.DateRange , contentDescription = "")
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.Person , contentDescription = "")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfilePostsSection(
    modifier: Modifier = Modifier
){
    val post by ProfileRepository.observeProfilePosts()
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
    ){
        items(post.size){item->
            ProfilePostView(post.get(item))
        }
    }

}