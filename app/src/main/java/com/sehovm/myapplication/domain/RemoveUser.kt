package com.sehovm.myapplication.domain

class RemoveUser {

    fun removeUser(user: User) {
        val userListInst: GetUserList = GetUserList()
        var userList: ArrayList<User> = userListInst.getUserList()
        userList.remove(user)
    }
}