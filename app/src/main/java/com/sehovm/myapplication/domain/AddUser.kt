package com.sehovm.myapplication.domain

class AddUse(private val userListRepository: UserListRepository) {

    fun addUser(user: User) {
        userListRepository.addUser(user)
    }
}