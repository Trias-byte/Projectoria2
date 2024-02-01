package com.example.projectoria.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.LabelText
import com.example.projectoria.ui.elements.NormText

@Composable
fun MainAuthScreen(navController: NavController, vm: FbViewModel) {
    if (vm.signedIn.value){
        navController.navigate(DestinationScreen.Successful.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderText(text = "Добро пожаловать!")

        Spacer(modifier = Modifier.height(60.dp))

        NormText(text = "Для дальнейшей работы нужно ")
        Spacer(modifier = Modifier.height(25.dp))
        Box {
            Image(
                painter = painterResource(id = R.drawable.blue_button),
                contentDescription = "д",
                modifier = Modifier
                    .height(40.dp)
                    .clickable {
                        navController.navigate(route = DestinationScreen.SignUp.route) {
                            launchSingleTop = true
                        }

                    }
                    .width(40.dp),
                alignment = Alignment.CenterEnd

            )
            LabelText(text = "зарегестрироваться")
        }
        Spacer(modifier = Modifier.height(25.dp))
        NormText(text = "или")
        Spacer(modifier = Modifier.height(25.dp))

        Box {
            Image(
                painter = painterResource(id = R.drawable.red_button),
                contentDescription = "д",
                modifier = Modifier
                    .height(40.dp)
                    .clickable {
                        navController.navigate(route = DestinationScreen.SignIn.route) {
                            launchSingleTop = true
                        }

                    }
                    .width(40.dp),
                alignment = Alignment.CenterEnd

            )
            LabelText(text = "войти в аккаунт ")
        }
    }
}