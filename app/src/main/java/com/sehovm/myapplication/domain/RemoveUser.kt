package com.sehovm.myapplication.domain

class RemoveUser(private val userListRepository: UserListRepository) {

    fun removeUser(user: User) {
        userListRepository.removeUser(user)
    }
}