package com.sitaram.composeapp.features.setting

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composeapp.R

@Composable
fun SettingsScreen() {
    val showDialog = remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(5.dp),
            horizontalArrangement = Arrangement.End // gravity end
        ) {
            IconButton(onClick = { showDialog.value = true }) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Add Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.LightGray,
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Setting",
                color = Color.White,
                fontSize = 50.sp
            )
        }

        // if press the button the show the dialog box
        if (showDialog.value) {
            DialogBox(onDismiss = { showDialog.value = false })
        }
    }
}

// logout dialog box
@Composable
fun DialogBox(onDismiss: () -> Unit) {
    val activity = (LocalContext.current as Activity)
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(stringResource(id = R.string.logout)) },
        text = { Text(text = "Are you sure you want to log out?") },
        modifier = Modifier.fillMaxWidth(),
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(
                onClick = { activity.finish() }
            ) {
                Text(text = "Yes")
            }
        }
    )
}

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
//    val scope = rememberCoroutineScope()
//    // or ScrollableToRow
//    TabRow(
//        selectedTabIndex = pagerState.currentPage,
//        Modifier.background(color = colorResource(id = androidx.appcompat.R.color.primary_dark_material_light)),
//        contentColor = Color.White,
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
////                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
//            )
//        }
//    ) {
//        tabs.forEachIndexed { index, tab ->
//            // OR Tab()
//            LeadingIconTab(
//                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = "") },
//                text = { Text(tab.title) },
//                selected = pagerState.currentPage == index,
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(index)
//                    }
//                },
//            )
//        }
//    }
//}

//
//@OptIn(ExperimentalFoundationApi::class)
//@ExperimentalPagerApi
//@Composable
//fun HorizontalPager(
//    state: PagerState,
//    modifier: Modifier = Modifier,
//    reverseLayout: Boolean = false,
//    itemSpacing: Dp = 0.dp,
//    dragEnabled: Boolean = true,
//    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
//    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
//    content: @Composable PagerScope.(page: Int) -> Unit,
//){}
//
//@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
//@Composable
//fun TabContent(pagerState: PagerState) {
//    HorizontalPager(state = pagerState) { index ->
//        when (index) {
//            0 -> {
//                MusicScreen()
//            }
//
//            1 -> {
//                MusicScreen()
//            }
//
//            2 -> {
//                BooksScreen()
//            }
//
//            3 -> {
//                NewsScreen()
//            }
//        }
//    }
//}

@Composable
fun MusicScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Music Screen")
    }
}

@Composable
fun MoviesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Movies Screen")
    }
}

@Composable
fun BooksScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Book Screen")
    }
}

@Composable
fun NewsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Book Screen")
    }
}