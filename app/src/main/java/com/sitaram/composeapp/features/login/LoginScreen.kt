package com.sitaram.composeapp.features.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.sitaram.composeapp.R
import com.sitaram.composeapp.R.color
import com.sitaram.composeapp.features.util.CheckboxComponent
import com.sitaram.composeapp.features.util.HeadingTextComponent
import com.sitaram.composeapp.features.util.InputTextField
import com.sitaram.composeapp.features.util.NormalTextComponent
import com.sitaram.composeapp.features.util.PasswordTextField
import com.sitaram.composeapp.features.main.User

// Main/Parent UI design for Sign Up Screen
@Composable
fun ViewOfLoginScreen(navController: NavHostController) {

    val context = LocalContext.current
    val loginViewModel = LoginViewModel()

    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    // Login button click handler
    val onLoginClick: () -> Unit = {
        val isValidLogin = loginViewModel.loginDetails(userName, userPassword, context)
        if (isValidLogin == true) {
            // Navigate to the home screen
            navController.navigate(User.Main.route) {
                // Kill the Login screen
                popUpTo(User.Login.route) {
                    inclusive = true
                }
            }
            Toast.makeText(context, "Login Successful.", Toast.LENGTH_SHORT).show()
        }
    }

    // sign screen page
    Surface(modifier = Modifier.fillMaxSize()) {
        // child layout file
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
        ) {
            NormalTextComponent(
                text = stringResource(id = R.string.hey),
                color = colorResource(id = color.softBlack)
            ) // text

            HeadingTextComponent(
                value = stringResource(id = R.string.login_your_details),
                color = colorResource(id = color.black)
            )

            Spacer(modifier = Modifier.height(50.dp)) // marginTop/space

            // username
            InputTextField(
                userName,
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
                "Enter the valid username"
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))
            // password
            PasswordTextField(
                userPassword,
                painterResource = painterResource(id = R.drawable.ic_lock),
                onValueChange = { userPassword = it },
                label = stringResource(id = R.string.userPassword)
            )

            // checkbox
            CheckboxComponent()

            Spacer(modifier = Modifier.height(30.dp))

            // login button
            LoginButton(
                value = stringResource(id = R.string.login),
                onClickAction = onLoginClick
            )

            Spacer(modifier = Modifier.height(50.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // divider
            // register text
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(
                    text = stringResource(id = R.string.register_your),
                    color = colorResource(id = color.softBlack)
                )
                RegisterTextComponent(
                    value = stringResource(id = R.string.account),
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun LoginButton(value: String, onClickAction: () -> Unit) {
    Button(
        onClick = onClickAction,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent) // Change the button color here
    ) {
        Text(
            fontSize = 20.sp,
            text = value,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp)
        )
    }
//    Button(
//        onClick = onClickAction,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//    ) {
//        Text(
//            fontSize = 20.sp,
//            text = value,
//            fontWeight = FontWeight.SemiBold,
//            color = DefaultShadowColor
//        )
//    }
//    Button(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//        contentPadding = PaddingValues(15.dp),
//        onClick = onClickAction,
//    ) {
//        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//    }
}

// account
@Composable
fun RegisterTextComponent(value: String, navController: NavController) {
    ClickableText(
        text = AnnotatedString(value),
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        ),
        onClick = {
            navController.navigate(User.Register.route)
        }
    )
}