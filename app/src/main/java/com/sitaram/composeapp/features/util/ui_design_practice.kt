package com.sitaram.composeapp.features.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.sitaram.composeapp.R
import com.sitaram.composeapp.features.main.ScreenItem.Game.icon
import com.sitaram.composeapp.ui.theme.Purple


@Preview
@Composable
fun InputTextDesign() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)) {
            OutlinedTextFieldDesign()
        }
    }
}

@Composable
fun OutlinedTextFieldDesign() {
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
        modifier = Modifier
            .fillMaxWidth()
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
fun CheckBokView(){
    var check by remember { mutableStateOf(false) }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = check, onCheckedChange = { check = it})
        if (check){
            Text(text = "Check")
        } else {
            Text(text = "Un-check")
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
            .padding(15.dp)) {
        Text("Select an option: ", Modifier.padding(start = 15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            radioOptions.forEachIndexed { index, text ->
                Row(modifier = Modifier.padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownView() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Nepal","India","China","Bhutan","Thailand","Singapur","Canada")
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.ArrowBack //it requires androidx.compose.material:material-icons-extended
    else
        Icons.Filled.ArrowDropDown
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Country")},
            trailingIcon = {
                Icon(Icons.Default.KeyboardArrowUp,"contentDescription", Modifier.clickable { expanded = !expanded })
            },
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
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
