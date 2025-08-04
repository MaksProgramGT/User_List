package com.sehovm.myapplication.domain

interface UserListRepository {

    fun editUser(user: User)

    fun addUser(user: User)

    fun removeUser(user: User)

    fun getUserById(id: Int): User?

    fun getUserList(): ArrayList<User>
}