package com.example.projectoria.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.LabelText
import com.example.projectoria.ui.elements.NormText
import com.example.projectoria.ui.elements.TopMenu

@Composable
fun MainAuthScreen(navController: NavController, vm: FbViewModel) {
    if (vm.signedIn.value){
        navController.navigate(DestinationScreen.Successful.route)
    }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier.fillMaxSize())
    {

        Box(modifier = Modifier.weight(1f)){
            TopMenu()
        }

        Column(

            modifier = Modifier
                .weight(4f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            HeaderText(text = "Добро пожаловать!")

            Spacer(modifier = Modifier.height(60.dp))

            NormText(text = "Для дальнейшей работы нужно ")
            Spacer(modifier = Modifier.height(25.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFAFB4F5), Color(0xFFAFB4F5))
                        )
                    )
            ) {
                Button(onClick = {
                    navController.navigate(route = DestinationScreen.SignUp.route) {
                        launchSingleTop = true
                    }

                },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    LabelText(text = "заригестрироваться")
                }
            }

            Spacer(modifier = Modifier.height(25.dp))
            NormText(text = "или")
            Spacer(modifier = Modifier.height(25.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF8F83), Color(0xFFFF8F83))
                        )
                    )
            ) {
                Button(onClick = {
                    navController.navigate(route = DestinationScreen.SignIn.route) {
                        launchSingleTop = true
                    }

                },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    LabelText(text = "войти в аккаунт ")
                }
            }


        }

        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            BottomMenu()
        }

    }

}