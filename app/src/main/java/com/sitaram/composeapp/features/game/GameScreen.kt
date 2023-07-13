package com.sitaram.composeapp.features.game

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sitaram.composeapp.R
import com.sitaram.composeapp.features.game.pojo.GameItems


//private const val TAG = "GameScreen"
val gameViewModel = GameViewModel()

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen() {

    val context = LocalContext.current

    val gameList = remember {
        mutableStateOf(ArrayList<GameItems>())
    }

    LaunchedEffect(true) {
        gameViewModel.getGames(context) {
            gameList.value = it as ArrayList<GameItems>
        }
    }

    getListOfGames(gameList)
}

@SuppressLint("ComposableNaming")
@Composable
fun getListOfGames(gameList: MutableState<ArrayList<GameItems>>) {
    LazyColumn {
        items(gameList.value.size) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(text = gameList.value[it].id.toString())
                Text(text = gameList.value[it].title ?: "title")
                Image(
                    painter = rememberAsyncImagePainter(gameList.value[it].thumbnail ?: "image"),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                Text(text = gameList.value[it].shortDescription ?: "descriptions")
                Text(text = gameList.value[it].releaseDate ?: "releaseDate")
                Text(text = gameList.value[it].freetogameProfileUrl ?: "freetogameProfileUrl")
                Text(text = gameList.value[it].genre ?: "genre")
                Text(text = gameList.value[it].publisher ?: "publisher")
                Text(text = gameList.value[it].developer ?: "developer")
                Text(text = gameList.value[it].platform ?: "platform")
            }
            Divider(modifier = Modifier.fillMaxWidth().padding(20.dp)) // divider
        }
    }
}
