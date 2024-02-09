package com.example.projectoria.pages.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.R
import com.example.projectoria.ui.elements.BottomMenu
import com.example.projectoria.ui.elements.BottomMenuActive
import com.example.projectoria.ui.elements.Demo_ExposedDropdownMenuBox
import com.example.projectoria.ui.elements.Demo_ExposedDropdownMenuBoxWithMultipleChoice
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.ImportantText
import com.example.projectoria.ui.elements.LabelText
import com.example.projectoria.ui.elements.TextInput
import com.example.projectoria.ui.elements.TopMenu


@Composable
fun ProjectRegistration(navController: NavController, vm: FbViewModel){

    val names = remember{ mutableStateOf( "" ) }
    val subject = remember{ mutableStateOf( "" ) }
    val masterName = remember{ mutableStateOf( "" ) }
    val projectName = remember{ mutableStateOf( "" ) }
    val topic = remember{ mutableStateOf( "" ) }
    val problem = remember{ mutableStateOf( "" ) }
    val hypothesis = remember{ mutableStateOf( "" ) }
    val description = remember{ mutableStateOf( "" ) }
    val relevance = remember{ mutableStateOf( "" ) }


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

            HeaderText(text = "Создать проект")
            Spacer(modifier = Modifier.height(30.dp))
            TextInput(placeholder = "Название проекта", FieldIcon = R.drawable.ab,
                value = projectName.value,
                funny = { projectName.value = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Логины (Авторы)", FieldIcon = R.drawable.person,
                value = names.value,
                funny = { names.value = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "ФИО куратора", FieldIcon = R.drawable.teachers,
                value = masterName.value,
                funny = { masterName.value = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Image(painter = painterResource(R.drawable.subject), contentDescription = "Subject")
                Demo_ExposedDropdownMenuBoxWithMultipleChoice(
                    arrayOf(
                        "Английский язык",
                        "Астрономия",
                        "Биология",
                        "География",
                        "Изобразительное искусство",
                        "Информатика",
                        "История",
                        "Литература",
                        "Математика",
                        "ОБЖ",
                        "Обществознание",
                        "Русский язык",
                        "Технология",
                        "Физика",
                    ),
                    subject.value,
                    funny = { subject.value = it }
                )
            }


            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Тема проекта", FieldIcon = R.drawable.project_idea,
                value = topic.value,
                funny = { topic.value = it },
                lines = 3
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Проблемы", FieldIcon = R.drawable.problem,
                value = problem.value,
                funny = { problem.value = it },
                lines = 5
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Гипотезы", FieldIcon = R.drawable.info,
                value = hypothesis.value,
                funny = { hypothesis.value = it },
                lines = 5
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Краткое описание проекта", FieldIcon = R.drawable.hypothesis,
                value = description.value,
                funny = { description.value = it },
                lines = 5
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextInput(placeholder = "Актуальность", FieldIcon = R.drawable.trends,
                value = relevance.value,
                funny = { relevance.value = it },
                lines = 5
            )

            Spacer(modifier = Modifier.height(20.dp))
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

                    if (names.value.isNotEmpty()){
                        if (subject.value.isNotEmpty()){
                            if (masterName.value.isNotEmpty()){
                                if(projectName.value.isNotEmpty()){
                                    if(topic.value.isNotEmpty()){
                                        if (problem.value.isNotEmpty()){
                                            if(hypothesis.value.isNotEmpty()){
                                                if(description.value.isNotEmpty()){
                                                    if(relevance.value.isNotEmpty()){

                                                        vm.createProject(FbViewModel.Project(
                                                            names.value,
                                                            subject.value,
                                                            masterName.value,
                                                            projectName.value,
                                                            topic.value,
                                                            problem.value,
                                                            hypothesis.value,
                                                            description.value,
                                                            relevance.value)
                                                        )
                                                        navController.navigate(route = DestinationScreen.ProjectList.route) {
                                                            launchSingleTop = true
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }



                },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    LabelText(text = "Создать")
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