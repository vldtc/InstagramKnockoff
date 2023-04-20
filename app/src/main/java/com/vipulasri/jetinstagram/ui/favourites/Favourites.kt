package com.vipulasri.jetinstagram.ui.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.FavouriteRepository
import com.vipulasri.jetinstagram.model.Favourite
import com.vipulasri.jetinstagram.ui.components.icon

@Composable
fun Favourites() {

    val couroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { Toolbar() }
    ) {
        val favs by FavouriteRepository.favs
        Column {
            FavInfo()
            SearchBar()

            LazyColumn (
                modifier = Modifier
                    .padding(top = 10.dp)
                    ){
                itemsIndexed(favs) { _, fav ->
                    Fav(fav)
                }
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
            Icons.Default.Close,
            modifier = Modifier.icon(),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.favourites_title),
            fontWeight = FontWeight.Bold
        )
        Icon(
            Icons.Default.Add,
            modifier = Modifier.icon(),
            contentDescription = null
        )
    }
}

@Composable
private fun FavInfo(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.favInfoText),
            )
        }
    }


}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.search)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
private fun Fav(
    fav: Favourite
) {
    FavouriteView(fav)
}