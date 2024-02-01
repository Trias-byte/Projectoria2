package com.example.projectoria.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projectoria.R

@Composable
fun TopMenu(){
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(110.dp)
            .width(352.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sc_pr_top),
            contentDescription = "top",
            modifier = Modifier
                .width(292.dp)
                .height(110.dp)
        )
    }
}