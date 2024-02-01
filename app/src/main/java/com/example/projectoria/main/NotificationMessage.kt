package com.example.projectoria.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.projectoria.FbViewModel

@Composable
fun NotificationMessage(vm: FbViewModel) {
    val notificationState = vm.popupNotification.value
    val notificationMessage = notificationState?.getContentOrNull()

    if (notificationMessage != null){
        Toast.makeText(LocalContext.current, notificationMessage, Toast.LENGTH_SHORT).show()
    }
}