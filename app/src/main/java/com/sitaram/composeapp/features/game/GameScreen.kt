package com.sitaram.composeapp.features.game

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.sitaram.composeapp.features.game.pojo.GameItems

val gameViewModel = GameViewModel()

@Composable
fun GameScreen(list: List<Any>? = null) {

    val context = LocalContext.current

    gameViewModel.getGames(context, onListReceived = {

//        Column(modifier = Modifier.fillMaxSize()) {
//            // Display the list of games
//            getGame(onListReceived)
//        }
    })
}


@SuppressLint("ComposableNaming")
@Composable
fun getGame(gameList: List<GameItems>?) {
    if (gameList != null) {
        LazyColumn {
            items(gameList) { game ->
                Text(text = game.title.toString())
            }
        }
    } else {
        // Show a loading indicator or error message when the list of games is null
        Text(text = "Loading...")
    }
}


//@Composable
//fun GameScreens(list: List<Any>? = null) {
//
//    val model: GameViewModel = viewModel()
//    val context = LocalContext.current
//
//    LaunchedEffect(key1 = true) {
//        model.getGames(context) // Fetch the list of games
//    }
//
//    val gameList: List<GameItems> by model.games.observeAsState(emptyList())
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Display the list of games
//        getGame(gameList)
//    }
//}


////    val context = LocalContext.current
//    val gameViewModel = GameViewModel()
////    gameViewModel.getGames(context) // call the getGames methods
////
//    val listOfGames = gameViewModel.gamesList
////
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Display the list of games
//        getGame(listOfGames)
//    }
//}
