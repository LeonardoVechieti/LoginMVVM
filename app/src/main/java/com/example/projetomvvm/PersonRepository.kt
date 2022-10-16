package com.example.projetomvvm

class PersonRepository {

    fun login (email: String, password: String) : Boolean {
       if (email != "" && password != "") {
           return true
       }
        return false
    }
}