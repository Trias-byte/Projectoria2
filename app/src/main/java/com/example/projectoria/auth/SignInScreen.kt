package com.example.projectoria.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.ImportantText
import com.example.projectoria.ui.elements.TextInput
import com.example.projectoria.ui.elements.TopMenu

@Composable
fun SignInScreen(navController: NavController, vm: FbViewModel) {
    val email = remember{ mutableStateOf( "" ) }
    val loginPassword = rememberSaveable{ mutableStateOf( "" ) }
    val margin = 100.dp


    if (vm.signedIn.value){
        navController.navigate(DestinationScreen.Profile.route){
            popUpTo(navController.graph.findStartDestination().id)
        }
    }


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.weight(1f)){
            TopMenu()
        }


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(4f)
                .verticalScroll(state = rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(margin))

            HeaderText(text = "Вход")

            TextInput(placeholder = "Email", FieldIcon = R.drawable.mail,
                value = email.value,
                funny = { email.value = it }
            )
            TextInput(
                placeholder = "Password", FieldIcon = R.drawable.password,
                value = loginPassword.value,
                funny = { loginPassword.value = it },
                type = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImportantText(
                    text = "Регистрация",
                    modifier = Modifier.clickable {
                        navController.navigate(route = DestinationScreen.SignUp.route) {
                            launchSingleTop = true
                        }
                    }
                )
//                    Button(
//                        modifier = Modifier
//                            .background(color = Color.Green),
//
//                    ) {
                Image(
                    painter = painterResource(id = R.drawable.okey),
                    contentDescription = "д",
                    modifier = Modifier
                        .height(40.dp)
                        .clickable {
                            if (email.value.isNotEmpty() and loginPassword.value.isNotEmpty()) {
                                vm.login(
                                    email = email.value,
                                    password = loginPassword.value
                                )
                            }

                        }
                        .width(40.dp),
                    alignment = Alignment.CenterEnd

                )


            }
            Spacer(modifier = Modifier.height(margin))
        }

        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            BottomMenu()
        }

    }
}
