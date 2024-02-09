package com.example.projectoria.pages.projects

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectoria.DestinationScreen
import com.example.projectoria.FbViewModel
import com.example.projectoria.ui.elements.BottomMenuActive
import com.example.projectoria.ui.elements.HeaderText
import com.example.projectoria.ui.elements.LabelText
import com.example.projectoria.ui.elements.TopMenu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun ProjectList(navController: NavController, vm: FbViewModel) {


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
            val database = Firebase.database
            val projectReference = database.reference.child("Project")

            val projectListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                    val projects = dataSnapshot.getValue<Array<FbViewModel.Project>>()
                    // ...
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadProject:onCancelled", databaseError.toException())
                }
            }
            projectReference.addValueEventListener(projectListener)


//   Надо смотреть lazy column

        }

        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            BottomMenuActive(navController)
        }
    }
}