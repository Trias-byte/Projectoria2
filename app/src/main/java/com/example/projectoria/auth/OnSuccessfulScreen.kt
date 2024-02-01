package com.example.projectoria.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.projectoria.FbViewModel
import com.example.projectoria.ui.elements.HeaderText

@Composable
fun OnSuccessfulScreen(navController: NavController, vm: FbViewModel) {
    HeaderText(text = "Succsess")
}