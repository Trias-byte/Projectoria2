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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.ImportantText
import com.example.projectoria.ui.elements.NormText
import com.example.projectoria.ui.elements.TextInput
import com.example.projectoria.ui.elements.TopMenu

@Composable
fun SignUpScreen(navController: NavController, vm: FbViewModel) {
    val login = remember{ mutableStateOf( "" ) }
    val mail = remember{ mutableStateOf( "" ) }
    val password = rememberSaveable{ mutableStateOf( "" ) }
    val repeatPassword = rememberSaveable{ mutableStateOf( "" ) }


    val errorP = remember{ mutableStateOf("") }
    val errorRP = remember{ mutableStateOf("") }
    val passLength = remember{ mutableStateOf("") }

    var teacherImg by remember {
        mutableStateOf( R.drawable.teachers_gray)
    }

    var studentImg by remember {
        mutableStateOf( R.drawable.student)
    }

    val margin = 20.dp

    if (vm.signedIn.value){
        navController.navigate(DestinationScreen.Successful.route)
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier.fillMaxSize()
    ){
        TopMenu()

        Column(
//            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            if (vm.inProgress.value){
                CircularProgressIndicator()
            }
        }

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .verticalScroll(state = rememberScrollState())
        ) {

            HeaderText(text = "Регистрация")

            TextInput(placeholder = "Login", FieldIcon = R.drawable.person,
                value = login.value,
                funny = { login.value = it }
            )

            TextInput(placeholder = "Mail", FieldIcon = R.drawable.mail,
                value = mail.value,
                funny = { mail.value = it }
            )

            TextInput(
                placeholder = "Password", FieldIcon = R.drawable.password,
                value = password.value,
                funny = { password.value = it },
                type = KeyboardType.Password
            )

            TextInput(
                placeholder = "Repeat password", FieldIcon = R.drawable.password,
                value = repeatPassword.value,
                funny = { repeatPassword.value = it },
                type = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = studentImg),
                    contentDescription = "studentRole",
                    modifier = Modifier
                        .height(50.dp)
                        .clickable {
                            studentImg = R.drawable.student_blue
                            teacherImg = R.drawable.teachers_gray
                        }
                )
                Spacer(modifier = Modifier.width(30.dp))
                NormText(text = "or")
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = teacherImg),
                    contentDescription = "studentRole",
                    modifier = Modifier
                        .height(50.dp)
                        .clickable {
                            studentImg = R.drawable.student
                            teacherImg = R.drawable.teachers_red
                        }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImportantText(
                    text = "Войти",
                    modifier = Modifier.clickable {
                        navController.navigate(route = DestinationScreen.SignIn.route) {
                            launchSingleTop = true
                        }
                    }
                )
//
                Image(
                    painter = painterResource(id = R.drawable.okey),
                    contentDescription = "д",
                    modifier = Modifier
                        .clickable {
                            vm.onSignUp(
                                email = mail.value,
                                password = password.value
                            )
                        }
                        .height(40.dp)
                        .width(40.dp),
                    alignment = Alignment.CenterEnd

                )


            }

    }

        BottomMenu()
    }
}