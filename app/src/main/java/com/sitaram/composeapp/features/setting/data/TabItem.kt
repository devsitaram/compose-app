package com.sitaram.composeapp.features.setting.data

import androidx.compose.runtime.Composable
import com.sitaram.composeapp.R
import com.sitaram.composeapp.features.setting.BooksScreen
import com.sitaram.composeapp.features.setting.MoviesScreen
import com.sitaram.composeapp.features.setting.MusicScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Musics : TabItem(R.drawable.ic_music, "Music", { MusicScreen() })
    object Movies : TabItem(R.drawable.ic_movie, "Movies", { MoviesScreen() })
    object Books : TabItem(R.drawable.ic_book, "Books", { BooksScreen() })
}