package com.example.projectoria.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.LabelText

@Composable
fun OnSuccessfulScreen(navController: NavController, vm: FbViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        HeaderText(text = "Succsess")

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(
                    color = colorResource(id = R.color.important_red)
                )
        ) {
            Button(
                onClick = {
                    vm.logOut()
                    navController.navigate(route = DestinationScreen.MainAuth.route)

                },
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent
                ),
                modifier = Modifier.width(300.dp)
            ) {
                LabelText(text = "Выйти")
            }
        }

    }
}