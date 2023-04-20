package com.vipulasri.jetinstagram.ui.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.model.Favourite
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun FavouriteView(
    fav: Favourite
){
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        StoryImage(
            imageUrl = fav.user.image,
            Modifier
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.Top)
                .weight(2f),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "${fav.user.username}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${fav.user.name}"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Add"
            )
        }
    }
}