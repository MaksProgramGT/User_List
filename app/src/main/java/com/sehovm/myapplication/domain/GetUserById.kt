package com.sehovm.myapplication.domain

import com.sehovm.myapplication.data.DBManager

class GetUserById(private val dbManager: DBManager) {

    fun getUserById(id: Int): User {
        return dbManager.getUserById(id)
    }
}