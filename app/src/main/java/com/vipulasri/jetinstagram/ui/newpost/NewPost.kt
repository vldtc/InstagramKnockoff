package com.vipulasri.jetinstagram.ui.newpost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.ui.components.icon

@Composable
fun NewPost() {
    Scaffold(
        topBar = { Toolbar() }
    ) {
        Column() {
            PictureCaptionSection()
        }
    }
}

@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .height(56.dp)
            .background(color = Color(0xFFDDDDDD)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            modifier = Modifier
                .icon()
                .padding(start = 10.dp)
                .size(24.dp),
            contentDescription = null
        )
        Text(
            text = "New Post",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Share",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00A7E9),
            modifier = Modifier
                .padding(end = 10.dp)
        )
    }
}

@Composable
fun PictureCaptionSection(
) {
    Row(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter("https://source.unsplash.com/random/400x300?1"),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Write a caption..." ) },
            modifier = Modifier
                .background(color = Color(0xA7E9))
                .align(Alignment.Top),
        )
    }
}