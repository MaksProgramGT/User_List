package com.sehovm.myapplication.domain

import com.sehovm.myapplication.data.DBManager

class AddUser(private val dbManager: DBManager) {

    fun addUser(user: User) {
        dbManager.addUser(user)
    }
}