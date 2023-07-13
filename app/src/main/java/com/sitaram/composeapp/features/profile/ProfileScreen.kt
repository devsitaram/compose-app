package com.sitaram.composeapp.features.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.sitaram.composeapp.R

@Preview
@Composable
fun ProfileScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // box for image
        Box {
            Image(
                painter = painterResource(id = R.mipmap.img_login_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
        }
        // large card
        Card(
            modifier = Modifier
                .padding(top = 120.dp, bottom = 100.dp, start = 30.dp, end = 30.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(30.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(3.dp, color = Color.White)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF03A9F4),
                                Color(0xFFB232BD)
                            )
                        )
                    )
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Unlimited downloads",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 100.dp),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "for your limitless ideas",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 10.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = colorResource(id = R.color.softWhite),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Now with Flaticon exclusive content",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 10.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = colorResource(id = R.color.softWhite),
                    textAlign = TextAlign.Center
                )

                // input text fields to dropdown fields
                BasicUiDesign()
            }
        }

        // round card
        Column(
            Modifier.padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                Modifier
                    .width(130.dp)
                    .height(130.dp),
                shape = RoundedCornerShape(300.dp),
                border = BorderStroke(2.dp, color = Color.White),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = null,
                    Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

@Composable
fun BasicUiDesign() {
    Column(
        modifier = Modifier
            .padding(5.dp),
//            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // text field
        InputTextField()

        // button
        ButtonView()

        // check bok
        CheckBokView()

        // Radio Button
        RadioButtonView()

        // dropdown
        DropDownView()
    }
}

@Composable
fun InputTextField() {
    var text by remember { mutableStateOf("") }
    // normal Input text Filed
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Username") },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Cyan),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(15.dp)
            .background(color = Color.White) // Change the background color here
    )

    // out line Input text Filed
    OutlinedTextField(
        value = text, // input value
        onValueChange = { text = it }, // value change
        placeholder = { Text("Enter Username") }, // hint text
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(15.dp)
            .background(color = Color.White), // design
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // types of input
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = null
            ) // icon
        }
    )
}

@Composable
fun ButtonView() {
    // normal button
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red) // Change the button color here
    ) {
        Text(
            fontSize = 20.sp,
            text = "Ok",
            fontWeight = FontWeight.SemiBold,
        )
    }

    // out line button
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, color = Color.Blue),
        shape = ShapeDefaults.ExtraLarge
    ) {
        Text(text = "Ok", fontSize = 20.sp)
    }
}

@Composable
fun CheckBokView() {
    var check by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = check, onCheckedChange = { check = it })
        if (check) {
            Text(text = "Check", color = Color.White, fontWeight = FontWeight.SemiBold)
        } else {
            Text(text = "Un-check", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun RadioButtonView() {
    val radioOptions = listOf("Male", "Female", "Others")
    val selectedOption = remember { mutableStateOf(0) }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text("Select an option: ", Modifier.padding(start = 15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            radioOptions.forEachIndexed { index, text ->
                Row(
                    modifier = Modifier.padding(vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption.value == index,
                        onClick = { selectedOption.value = index },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Red) // Change the selected color here
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text)
                }
            }
        }
    }
}

@Composable
fun DropDownView() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Nepal", "India", "China", "Bhutan", "Thailand", "Singapore", "Canada")
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    // change the drop down icon
    val icon = if (expanded)
        Icons.Filled.ArrowBack
    else
        Icons.Filled.ArrowDropDown

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Country") },
            trailingIcon = {
                Icon(icon, "contentDescription", Modifier.clickable { expanded = !expanded })
            },
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                }) {
                    Text(text = label, color = Color.DarkGray)
                }
            }
        }
    }
}