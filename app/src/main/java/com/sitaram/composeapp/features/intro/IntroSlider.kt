package com.sitaram.composeapp.features.intro

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sitaram.composeapp.R
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroSlider(navController: NavHostController) {
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
//        ViewOfIntroSlider(navController)
    }
}

@Composable
fun ViewOfIntroSlider(navController: NavHostController) {
    Surface(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp), horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        navController.navigate("Login")
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.softBlue)),
                ) {
                    Text(text = "Skip")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.img_calendula),
                    contentDescription = null,
                    Modifier.height(100.dp)
                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = stringResource(id = R.string.calendula),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 200.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.softBlue)),
                    enabled = false
                ) {
                    Text(text = "Back")
                }
                Spacer(modifier = Modifier.width(160.dp))
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.softBlue)),
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}