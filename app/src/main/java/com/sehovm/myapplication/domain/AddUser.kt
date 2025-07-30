package com.sehovm.myapplication.domain

class AddUser {

    fun addUser(user: User) {
        val userListInst: GetUserList = GetUserList()
        var userList: ArrayList<User> = userListInst.getUserList()
        userList.add(user)
    }
}