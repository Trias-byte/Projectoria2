package com.example.projectoria.pages

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun TestCreator(){
    val database = Firebase.database

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }



    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        TextField(
            value = name,
            onValueChange = { newText ->
                name = newText
            },

        )
        TextField(
            value = email,
            onValueChange = { newText ->
                email = newText
            },


            )
        TextField(
            value = phone,
            onValueChange = { newText ->
                phone = newText
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                val contactRef = database.reference.child(name)
                val contact = Contact(email, phone)
                contactRef.setValue(contact)
                name = ""
                email = ""
                phone = ""
            }

        ) {
            Text(text = "Submit")

        }
    }

}

data class Contact(val email: String,val phone:String)


@Preview
@Composable
fun SimpleComposablePreview() {
    TestCreator()
}
