package com.example.projectoria.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projectoria.R

@Composable
fun BottomMenu(){
    var menuVisibility by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(110.dp)
            .width(352.dp)
    ) {

        Row(
            modifier = Modifier
                .height(110.dp)
                .fillMaxSize()
                .background(Color.Transparent),

            horizontalArrangement = Arrangement.End
        ){
            Image(
                painter = painterResource(id = R.drawable.sc_pr_botom),
                contentDescription = "bottom",
                modifier = Modifier
                    .width(292.dp)
                    .height(110.dp)
                    .clickable {
                        ++menuVisibility
                    }
            )
        }
    }
}

private operator fun Boolean.inc() = !this

