package com.example.projectoria

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
//import com.example.projectoria.domain.use_cases.AuthenticationUseCases
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FbViewModel @Inject constructor(
    val auth: FirebaseAuth

): ViewModel(){



    val signedIn = mutableStateOf(false)
    val inProgress = mutableStateOf(false)
    val popupNotification = mutableStateOf<Event<String>?>(null)
    val error = mutableStateOf(false)

    fun onSignUp(email: String, password:String){
        inProgress.value = true

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    signedIn.value = true
                    handlerException(it.exception, "login successful")
                }
                else{
                    handlerException(it.exception, "signUp failed")
                }
                inProgress.value = false
            }
    }

    fun login(email: String, password:String){
        inProgress.value = true

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    signedIn.value = true
                    handlerException(it.exception, "login successful")
                }
                else{
                    handlerException(it.exception, "login failed")
                }
                inProgress.value = false
            }
    }

    fun handlerException(exception: Exception? = null, customMessage: String = ""){
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message = if (customMessage.isEmpty()) errorMsg else "$customMessage: $errorMsg"
        popupNotification.value = Event(message)
    }
}