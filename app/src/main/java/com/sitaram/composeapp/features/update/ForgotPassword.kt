package com.sitaram.composeapp.features.update

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composeapp.R
import com.sitaram.composeapp.features.util.DialogBox
import com.sitaram.composeapp.features.util.InputTextField
import com.sitaram.composeapp.features.util.NormalButton

@Preview
@Composable
fun PasswordUpdateViewScreen() {
    var visible by remember { mutableStateOf(true) }

    val showDialog = remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }

    val onClickEmailCheck: ()-> Unit = {
        visible = false
    }

    val onClickPasswordCheck: ()-> Unit = {
        visible = true
    }

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                Modifier
                    .width(150.dp)
                    .height(150.dp),
                shape = RoundedCornerShape(300.dp),
                border = BorderStroke(2.dp, color = Color.Red),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .background(Color.Cyan),
                )
            }

            Text(
                text = "Forgot password?",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                ),
                color = Color.DarkGray
            )

            // email check
            Box(modifier = Modifier.wrapContentHeight()) {
                if (visible) {
                    Column(modifier = Modifier.background(Color.Yellow)) {
                        Spacer(modifier = Modifier.padding(top = 40.dp))
                        InputTextField(
                            email,
                            onValueChange = { email = it },
                            label = stringResource(id = R.string.userEmail),
                            "Enter the valid email"
                        )
                        Spacer(modifier = Modifier.padding(top = 30.dp))
                        NormalButton(value = "New password", onClickAction = onClickEmailCheck)
                    }
                } else {
                    // new password
                    Column(modifier = Modifier.background(Color.Green)) {
                        Spacer(modifier = Modifier.padding(top = 40.dp))
                        InputTextField(
                            email,
                            onValueChange = { email = it },
                            label = stringResource(id = R.string.userEmail),
                            "Enter the valid email"
                        )
                        Spacer(modifier = Modifier.padding(top = 30.dp))
                        NormalButton(value = "New password", onClickAction = onClickPasswordCheck)
                    }
                }

                // new design
            }
        }

        if (showDialog.value) {
            DialogBox(onDismiss = { showDialog.value = false })
        }
    }
}