package com.example.projectoria

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.projectoria.pages.Contact
//import com.example.projectoria.domain.use_cases.AuthenticationUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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
    val fullSignUp = mutableStateOf(false)

    fun onSignUp(email: String, password:String, login: String, areTeacher:Boolean, ){
        inProgress.value = true

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    signedIn.value = true
                    val database = Firebase.database
                    val userReference = database.reference.child("UsersData")

                    val userInf = UserInf(login, email, areTeacher)
                    userReference.child(auth.uid.toString()).setValue(userInf)
                    handlerException(it.exception, "login successful")
                }
                else{
                    handlerException(it.exception, "signUp failed")
                }
                inProgress.value = false
            }
    }

    fun detailStudentSignUp(name:String, form:String, subject: String){
        inProgress.value = true
        val fullName = name.split(" ").toTypedArray()

        if  ( fullName.size < 3 ){
            handlerException(customMessage = "Заполните поле имя")
            return
        }else if(form.isEmpty() and subject.isEmpty()){
            if (form.isEmpty()){
                handlerException(customMessage = "Выберите класс")
            }
            if (subject.isEmpty()){
                handlerException(customMessage = "Выберите предмет")
            }
            return
        }
        else{
            val database = Firebase.database.reference
            val userReference = database.child("UsersData").child(auth.uid.toString())
            userReference.child("firstName").setValue(fullName[0])
            userReference.child("lastName").setValue(fullName[1])
            userReference.child("fatherName").setValue(fullName[2])

            userReference.child("form").setValue(form)
            userReference.child("subject").setValue(subject)







            fullSignUp.value = true
            inProgress.value = false
        }
    }
    @IgnoreExtraProperties
    data class UserInf(
        val login:String? = "",
        val email: String? = "",
        val areTeacher: Boolean? = false,
        val firstName: String? = "",
        val lastName: String? = "",
        val fatherName: String? = "",
        val form: String? = "",
        val subject: String? = ""

    ){
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "login" to login,
                "email" to email,
                "areTeacher" to areTeacher,
                "firstName" to firstName,
                "lastName" to lastName,
                "fatherName" to fatherName,
                "form" to form,
                "subject" to subject,
            )
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


    fun logOut(){
        inProgress.value = true

        auth.signOut()

        signedIn.value = false

        inProgress.value = false

    }

    fun handlerException(exception: Exception? = null, customMessage: String = ""){
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message = if (customMessage.isEmpty()) errorMsg else "$customMessage: $errorMsg"
        popupNotification.value = Event(message)
    }
}