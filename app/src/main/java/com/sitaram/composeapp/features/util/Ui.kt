package com.sitaram.composeapp.features.util

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composeapp.R
import com.sitaram.composeapp.ui.theme.Purple

// normal text
@Composable
fun NormalTextComponent(text: String, color: Color) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),  // Specify the desired padding value
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center,
        color = color
    )
}

// heading text
@Composable
fun HeadingTextComponent(value: String, color: Color) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        ),
        color = color,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit = {},
    label: String,
    painterResource: Painter,
) {
    Column {
        // if the fields is empty then show error message
        if (value.isEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Enter the valid $label", color = Color.Red)
        }
        // input text fields
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(top = 5.dp),
            // text fields bar's text
            label = {
                Text(label)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedLabelColor = Purple,
                cursorColor = Purple
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(painter = painterResource, contentDescription = "")
            },
        )
    }
}

// password input text
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    value: String,
    painterResource: Painter,
    onValueChange: (String) -> Unit = {},
    label: String
) {
    Column {
        val passwordVisible = remember { mutableStateOf(false) }
        // if the fields is empty then show error message
        if (value.isEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Enter the valid $label", color = Color.Red)
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            label = {
                Text(label)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Purple,
//                focusedLabelColor = Purple,
                cursorColor = Purple
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            // lest side icon
            leadingIcon = {
                Icon(painter = painterResource, contentDescription = "")
            },
            // right side icon
            trailingIcon = {
                val iconImage = if (passwordVisible.value) {
//                    Icons.Filled.Visibility
                    painterResource(R.drawable.ic_password_invisible)
                } else {
                    painterResource(R.drawable.ic_password_visible)
                }
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(painter = iconImage, contentDescription = null)
                }
            },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )
    }
}

// check box
@Composable
fun CheckboxComponent() {
    var checkedState by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.DarkGray,
                uncheckedColor = Color.Gray
            )
        )
        Text(text = if (checkedState) "Checked" else "Unchecked"
        )
    }
}

// normal button
@Composable
fun NormalButton(value: String, onClickAction: () -> Unit) {
    Button(
        onClick = onClickAction,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
//        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent) // Change the button color here
    ) {
        Text(
            fontSize = 15.sp,
            text = value,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(5.dp)
        )
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
                onClick = { onDismiss() }
            ) {
                Text(text = "Yes")
            }
        }
    )
}