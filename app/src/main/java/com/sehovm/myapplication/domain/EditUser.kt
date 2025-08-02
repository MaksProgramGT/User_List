package com.sehovm.myapplication.domain

class EditUser(private val userListRepository: UserListRepository) {

    fun editUser(user: User) {
        userListRepository.editUser(user)
    }
}