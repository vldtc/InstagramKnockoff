package com.vipulasri.jetinstagram.ui.newpost

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.model.places
import com.vipulasri.jetinstagram.model.songs
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun NewPost() {
    Scaffold(
        topBar = { Toolbar() }
    ) {
        LazyColumn {
            item {
                Divider()
                PictureCaptionSection()
                Divider()
                SimpleSection("Add Title")
                Divider()
                AddLocationSection()
                Divider()
                AddMusicSection()
                Divider()
                SimpleSection("Add Fundraiser")
                Divider()
                OtherIGAccountsSection()
                Divider()
                ShareSection(name = currentUser.name)
                Divider()
                SimpleSection("Advanced Settings")
                Divider()
            }
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
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "New post",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Share",
            style = MaterialTheme.typography.button,
            fontWeight = FontWeight.Bold,
            color = Color(color = 0xFF009AF9)
        )
    }
}

@Composable
fun PictureCaptionSection(
) {
    TextField(
        value = "",
        onValueChange = { /*TODO*/ },
        placeholder = {
            Text(
                text = "Write a caption...",
                style = MaterialTheme.typography.caption.copy(color = Color.Gray)
            )
        },
        maxLines = 15,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Image(
                painter = rememberImagePainter("https://source.unsplash.com/random/400x300?1"),
                contentDescription = "Instagram logo",
                modifier = Modifier
                    .size(height = 120.dp, width = 100.dp)
                    .padding(16.dp)
                    .border(1.dp, Color.Black),
                contentScale = ContentScale.FillBounds
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            textColor = Color.Black
        )
    )
}

@Composable
fun SimpleSection(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black
        )
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )

    }
}

@Composable
fun AddLocationSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Add location",
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black
        )
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = "My Drawable",
            modifier = Modifier.size(24.dp)
        )
    }
    LocationsRow()
}

@Composable
fun LocationsRow() {
    LazyRow(
        Modifier
            .padding(horizontal = 12.dp),
        contentPadding = PaddingValues(horizontal = 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(places) { place ->
            Card(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = place,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 5.dp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun AddMusicSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Add music",
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black
        )
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = "My Drawable",
            modifier = Modifier.size(24.dp)
        )
    }
    SongsRow()
}

@Composable
fun SongsRow() {
    LazyRow(
        Modifier
            .padding(horizontal = 12.dp),
        contentPadding = PaddingValues(horizontal = 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(songs) { song ->
            Card(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 2.dp)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = song,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 5.dp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun OtherIGAccountsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Post to other Instagram accounts",
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black
        )
    }
    IGAccountsItem()
}

@Composable
fun IGAccountsItem() {
    Row(
        Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val profilePicture by StoriesRepository.observeStories()
        var toggleState by remember { mutableStateOf(false) }
        StoryImage(imageUrl = profilePicture.get(1).image, weight = Modifier.weight(1f))
        Text(
            text = "namaste_maniac",
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black,
            modifier = Modifier
                .weight(8f)
                .padding(start = 5.dp)
        )
        Switch(
            checked = toggleState,
            onCheckedChange = { isChecked -> toggleState = isChecked },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color.Blue
            )
        )
    }
}

@Composable
fun ShareSection(
    name: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var toggleState by remember { mutableStateOf(false) }
        Text(
            text = "Share to Facebook",
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
            color = Color.Black,
            modifier = Modifier.weight(8f)
        )
        Switch(
            checked = toggleState,
            onCheckedChange = { isChecked -> toggleState = isChecked },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color.Blue
            )
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Sharing as $name.Audience is Friends.",
            style = MaterialTheme.typography.h6.copy(fontSize = 12.sp),
            color = Color.Black.copy(alpha = 0.5f)
        )
    }
}
