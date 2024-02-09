package com.example.projectoria.pages.usersData

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.BottomMenuActive
import com.example.projectoria.ui.elements.Demo_ExposedDropdownMenuBoxWithMultipleChoice
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.LabelText
import com.example.projectoria.ui.elements.TextInput
import com.example.projectoria.ui.elements.TopMenu

@Composable
fun Profile(navController: NavController, vm: FbViewModel) {
    
//    if (vm.isTeacher() == true){
//        Teacher(navController, vm )
//    }
//    else if (vm.isTeacher() == false){
    Student(navController, vm )
//    }
//    else{
//        HeaderText(text = vm.isTeacher().toString())
//    }
}
@Composable
fun Student(navController: NavController, vm: FbViewModel){


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
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

            HeaderText(text = "Личная страница")

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF7DFF8A), Color(0xFF7DFF8A))
                        )
                    )
            ) {
                Button(onClick = {
                    navController.navigate(route = DestinationScreen.ProjectRegistration.route) {
                        launchSingleTop = true
                    }

                },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    LabelText(text = "Создать проект")
                }
            }

        }

        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            BottomMenuActive(navController)
        }
    }
}

@Composable
fun Teacher(navController: NavController, vm: FbViewModel){


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
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

            HeaderText(text = "Личная страница")

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF7DFF8A), Color(0xFF7DFF8A))
                        )
                    )
            ) {
                Button(onClick = {
                    navController.navigate(route = DestinationScreen.ProjectRegistration.route) {
                        launchSingleTop = true
                    }

                },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    LabelText(text = "Создать проект")
                }
            }

        }

        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            BottomMenuActive(navController)
        }
    }
}