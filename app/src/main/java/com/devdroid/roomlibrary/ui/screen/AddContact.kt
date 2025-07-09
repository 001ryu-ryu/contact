package com.devdroid.roomlibrary.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.devdroid.roomlibrary.viewModel.MyViewModel


@Composable
fun AddContact(viewModel: MyViewModel = hiltViewModel(), navController: NavHostController) {


    val name = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
  //  val image = remember { mutableStateOf<ByteArray?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") }
        )
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { Text("Phone Number") }
        )
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") }
        )

        ElevatedButton(
            onClick = {
                viewModel.addContact(name.value,
                    phoneNumber.value,
                    email.value)
            }
        ) {
            Text("Add Contact")

        }


    }




}