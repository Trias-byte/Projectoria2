package com.example.projectoria.ui.elements


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction

import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.getColor

import com.example.projectoria.R


// Text elements
@Composable
fun HeaderText(text: String, modifier: Modifier = Modifier){ // It's Headers
    Text(text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color =  colorResource(R.color.black),
        textAlign = TextAlign.Center,
    )
}


@Composable
fun ImportantText(text: String, modifier: Modifier = Modifier){ // It's to highlight some important text
    Text(text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelMedium,
        color =  colorResource(R.color.important_red),
        textAlign = TextAlign.Left,
    )
}

@Composable
fun BoldText(text: String, modifier: Modifier = Modifier){ // It's to highlight some text
    Text(text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = colorResource(R.color.bold_blue),
        textAlign = TextAlign.Left,
    )
}



@Composable
fun NormText(text: String, modifier: Modifier = Modifier){ // It's text
    Text(text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color =  colorResource(R.color.black),
        textAlign = TextAlign.Left,
    )
}


@Composable
fun LabelText(text: String, modifier: Modifier = Modifier){ // It's text
    Text(text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color =  colorResource(R.color.black),
        textAlign = TextAlign.Left,
    )
}



private operator fun Boolean.inc() = !this

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    FieldIcon: Int,
    value: String,
    funny: (String) -> Unit,
    type: KeyboardType = KeyboardType.Text,
    lines: Int = 1
) {
    if (type != KeyboardType.Password){
        TextField(
            value = value,

            onValueChange = funny,

            maxLines = lines,

            label = { Text(
                text = placeholder,
                style = MaterialTheme.typography.labelMedium,
                color = colorResource(id = R.color.login_black)
            )},

            placeholder = { Text(
                text = placeholder,
                style = MaterialTheme.typography.labelMedium,
            )},

            leadingIcon = {
                Icon(
                    painter = painterResource(id = FieldIcon),
                    contentDescription = placeholder
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = colorResource(id = R.color.login_),
                unfocusedIndicatorColor = colorResource(id = R.color.login_black)),

            textStyle = MaterialTheme.typography.labelMedium,

            keyboardOptions = KeyboardOptions(
                keyboardType = type,
                imeAction = ImeAction.Go
            ),

            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),

            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 23.dp),
        )}
    else{
        PasswordInput(placeholder = placeholder, value = value, funny = funny, FieldIcon = FieldIcon, modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(top = 23.dp),)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    FieldIcon: Int,
    value: String,
    funny: (String) -> Unit
){

    var hidePass  by remember { mutableStateOf(true) }

    val icon = if(hidePass)
        painterResource(id = R.drawable.eye_close)
    else
        painterResource(id = R.drawable.eye)

    val desc = if(hidePass)
        "Show password"
    else
        "Hide password"

    TextField(
        modifier = modifier,

        value = value,
        onValueChange = funny,

        placeholder = { Text(
            text = placeholder,
            style = MaterialTheme.typography.labelMedium,
        )},

        label = { Text(
            text = placeholder,
            style = MaterialTheme.typography.labelMedium,
            color = colorResource(id = R.color.login_black)
        )},

        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = colorResource(id = R.color.login_),
            unfocusedIndicatorColor = colorResource(id = R.color.login_black)),

        textStyle = MaterialTheme.typography.labelMedium,

        leadingIcon = {
            Icon(
                painter = painterResource(id = FieldIcon),
                contentDescription = placeholder
            )
        },
        trailingIcon = {
            IconButton(onClick = { hidePass++ }) {
                Icon(
                    painter = icon,
                    contentDescription = desc
                )
            }
        },

        visualTransformation =
        if(!hidePass)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    )
}
data class FormModel(val name:String, val type: KeyboardType, val image : Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox(array: Array<String>, value: String, funny: (String) -> Unit){
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .verticalScroll(rememberScrollState()),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                array.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            funny(item)
                            expanded = false
//                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBoxWithMultipleChoice(
    array: Array<String>,
    value: String,
    funny: (String) -> Unit
){
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }
    var list = emptyArray<String>()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = if (list.size <= 1) value else list[0] + " и еще ${list.size-1}",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .verticalScroll(rememberScrollState()),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                array.forEach { item ->
                    DropdownMenuItem(
                        modifier = Modifier.background( colorResource(R.color.white)),
                        text = { Text(text = item) },
                        onClick = {
                            var flag = false
                            var newList = emptyArray<String>()
                            for (its in list){
                                if (its != item){
                                    newList += item
                                }else{
                                    flag = true
                                }
                            }
                            list = newList

                            if(!flag){

                                list += item

                            }
                            funny(list.joinToString(" , "))
                            expanded = false

//                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        },

                    )
                }
            }
        }
    }
}