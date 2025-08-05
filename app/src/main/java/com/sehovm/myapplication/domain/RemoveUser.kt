package com.sehovm.myapplication.domain

import com.sehovm.myapplication.data.DBManager

class RemoveUser(private val dbManager: DBManager) {

    fun removeUser(user: User) {
        dbManager.removeUser(user)
    }
}