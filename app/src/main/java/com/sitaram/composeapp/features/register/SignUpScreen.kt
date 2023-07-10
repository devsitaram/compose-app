package com.sitaram.composeapp.features.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavHostController
import com.sitaram.composeapp.R
import com.sitaram.composeapp.features.main.User
import com.sitaram.composeapp.features.util.HeadingTextComponent
import com.sitaram.composeapp.features.util.InputTextField
import com.sitaram.composeapp.features.util.NormalTextComponent
import com.sitaram.composeapp.features.util.PasswordTextField

// Main/Parent UI design for Sign Up Screen
@Composable
fun ViewOfSignUpScreen(navController: NavHostController){

    val context = LocalContext.current
    var userEmail by remember {
        mutableStateOf("")
    }

    var userName by remember {
        mutableStateOf("")
    }

    var userPassword by remember {
        mutableStateOf("")
    }

    // if the input fields are not empty then the button is visible
    val isNotEmpty by remember {
        derivedStateOf {
            userEmail.isNotEmpty() && !userName.isEmpty() && !userPassword.isEmpty()
        }
    }

    // on click function
    val onClickAction: () -> Unit = {
        if (isNotEmpty) {
            val signUpViewModel = SignUpViewModel()
            val isValidRegister = signUpViewModel.registerDetail(userEmail, userName, userPassword, context)
            if (isValidRegister){
                navController.navigate(User.Login.route)
            }
        } else {
            Toast.makeText(context, "Invalid username!", Toast.LENGTH_LONG).show()
        }
    }

    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background
            .padding(30.dp) // padding
    ) {
        // child layout file
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally // gravity center
        ) {
            NormalTextComponent(
                text = stringResource(id = R.string.hey),
                color = colorResource(id = R.color.softBlack)
            )

            HeadingTextComponent(
                value = stringResource(id = R.string.create_an_account),
                color = colorResource(id = R.color.black)
            )

            Spacer(modifier = Modifier.height(40.dp)) // marginTop/space
            // email
            InputTextField(
                userEmail,
                painterResource(id = R.drawable.ic_email),
                onValueChange = { userEmail = it },
                label = stringResource(id = R.string.userEmail),
                "Enter the valid email"
            )

            // username
            InputTextField(
                userName,
                painterResource = painterResource(id = R.drawable.ic_person),
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
                "Enter the valid username"
            )

            // password
            PasswordTextField(
                userPassword,
                painterResource = painterResource(id = R.drawable.ic_lock),
                onValueChange = { userPassword = it },
                label = stringResource(id = R.string.userPassword)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // button
            RegisterButton(
                value = stringResource(id = R.string.signup),
                isEnabled = isNotEmpty,
                onClickAction = onClickAction,
            )

            Spacer(modifier = Modifier.height(70.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // using the divider
            // register text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(
                    text = stringResource(id = R.string.login_your),
                    color = colorResource(id = R.color.softBlack)
                )
                LoginTextComponent(
                    text = stringResource(id = R.string.account),
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RegisterButton(value: String, isEnabled: Boolean = false, onClickAction: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentPadding = PaddingValues(15.dp),
        enabled = isEnabled,
        onClick = onClickAction,
    ) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// account
@Composable
fun LoginTextComponent(text: String, navController: NavHostController) {
    ClickableText(
        text = AnnotatedString(text),
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        onClick = {
            navController.navigate(User.Login.route)
        })
}