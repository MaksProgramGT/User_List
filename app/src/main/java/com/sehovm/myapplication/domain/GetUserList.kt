package com.sehovm.myapplication.domain

import com.sehovm.myapplication.data.DBManager

class GetUserList(private val dbManager: DBManager) {

    fun getUserList(): ArrayList<User> {
        return dbManager.getUserList()
    }
}