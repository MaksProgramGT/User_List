package com.sehovm.myapplication.domain

import com.sehovm.myapplication.data.DBManager

class EditUser(private val dbManager: DBManager) {

    fun editUser(user: User) {
        dbManager.editUser(user)
    }
}