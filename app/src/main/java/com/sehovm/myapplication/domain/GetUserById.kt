package com.sehovm.myapplication.domain

class GetUserById(private val userListRepository: UserListRepository) {

    fun getUserById(id: Int): User {
        return userListRepository.getUserById(id)
    }
}