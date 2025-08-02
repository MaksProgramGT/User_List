package com.sehovm.myapplication.domain

class GetUserList(private val userListRepository: UserListRepository) {

    fun getUserList(): ArrayList<User> {
        return userListRepository.getUserList()
    }
}