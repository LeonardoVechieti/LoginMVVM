package com.example.projetomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private var personRepository = PersonRepository()

    init {
        textWelcome.value = "Olá, mundo!"
    }

    fun welcome() : LiveData<String> {
        //textWelcome.value = "Welcome to MVVM"
        return textWelcome
    }
    fun login() : LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, password: String) {
        login.value = personRepository.login(email, password)
    }

}