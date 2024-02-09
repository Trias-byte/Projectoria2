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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.R

enum class BottomNavigationItem(val icon: ImageVector, val route: DestinationScreen){
    FEED(Icons.Default.Home, DestinationScreen.ProjectList),
    SEARCH(Icons.Default.Search, DestinationScreen.Profile),
    PROFILE(Icons.Default.Person, DestinationScreen.Profile)

}

@Composable
fun BottomMenu (
//    navController: NavController
){
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
                .fillMaxSize()
                .background(Color.Transparent),
            verticalAlignment = Alignment.Bottom,
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


@Composable
fun BottomMenuActive (
    navController: NavController
){
    var menuVisibility by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(110.dp)
            .width(352.dp)
    ) {
        if (menuVisibility) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                for (item in BottomNavigationItem.entries){
                    Box(
                        modifier = Modifier
                            .clickable{
                                navController.navigate(item.route.route){

                                }
                            }
                    ) {
                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(25.dp),

                            imageVector = item.icon,
                            contentDescription = item.route.route,
                        )
                        Image(
                            modifier = Modifier
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.background_ellipse_menu),
                            contentDescription = "background_ellipse",

                            )

                    }

                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalAlignment = Alignment.Bottom,
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
