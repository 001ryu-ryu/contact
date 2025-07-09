package com.devdroid.roomlibrary.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroid.roomlibrary.model.database.Contact
import com.devdroid.roomlibrary.model.database.ContactDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class MyViewModel @Inject constructor(private val database: ContactDatabase)
    : ViewModel() {

        private val _getContacts = MutableStateFlow<List<Contact>>(emptyList())
        val getContacts = _getContacts.asStateFlow()

    fun getAllContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDao().getAllContact().collect {
                _getContacts.value = it
            }
        }

    }

    fun addContact(name: String, phoneNumber: String , email: String , image: ByteArray? = null) {
       val contact = Contact(
           name = name,
           phoneNumber = phoneNumber,
           email = email,
           image = image
       )
        viewModelScope.launch(Dispatchers.IO) {
            database.getDao().upsertContact(contact)
        }

    }
    fun deleteContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDao().deleteContact(contact)
        }

    }

}