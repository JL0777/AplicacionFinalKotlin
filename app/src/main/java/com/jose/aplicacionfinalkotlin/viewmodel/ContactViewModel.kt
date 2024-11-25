package com.jose.aplicacionfinalkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.jose.aplicacionfinalkotlin.AppDatabase
import com.jose.aplicacionfinalkotlin.Contact
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getInstance(application).contactDao()
    val allContacts: LiveData<List<Contact>> = dao.getAllContacts()

    fun insert(contact: Contact) {
        viewModelScope.launch {
            dao.insert(contact)
        }
    }

    fun delete(contact: Contact) {
        viewModelScope.launch {
            dao.delete(contact)
        }
    }

    fun update(contact: Contact) {
        viewModelScope.launch {
            dao.update(contact)
        }
    }
}