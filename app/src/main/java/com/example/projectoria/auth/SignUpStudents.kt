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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.Demo_ExposedDropdownMenuBox
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.ImportantText
import com.example.projectoria.ui.elements.NormText
import com.example.projectoria.ui.elements.TextInput
import com.example.projectoria.ui.elements.TopMenu
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun SignUpStudents(navController: NavController, vm: FbViewModel){

    val name = remember{ mutableStateOf( "" ) }
    val form = remember{ mutableStateOf( "" ) }
    val subject = remember{ mutableStateOf( "" ) }

    if (vm.signedIn.value and vm.fullSignUp.value){
        vm.fullSignUp.value = false
        navController.navigate(DestinationScreen.Successful.route)

    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ){
        Box(modifier = Modifier.weight(1f)){
            TopMenu()
        }

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
                .weight(4f)
                .verticalScroll(state = rememberScrollState())
        ) {

            HeaderText(text = "Регистрация")

            TextInput(placeholder = "Имя", FieldIcon = R.drawable.person,
                value = name.value,
                funny = { name.value = it }
            )

            Demo_ExposedDropdownMenuBox(arrayOf("9", "10", "11"), form.value,funny = { form.value = it })



            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImportantText(
                    text = "Войти",
                    modifier = Modifier.clickable {
//                        navController.navigate(route = DestinationScreen.SignIn.route) {
//                            launchSingleTop = true
//                        }
                    }
                )
//
                Image(
                    painter = painterResource(id = R.drawable.okey),
                    contentDescription = "д",
                    modifier = Modifier
                        .clickable {
                            vm.detailStudentSignUp(name.value, form.value, subject.value )

                        }
                        .height(40.dp)
                        .width(40.dp),
                    alignment = Alignment.CenterEnd

                )


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