package com.sehovm.myapplication.data

import com.sehovm.myapplication.domain.User
import com.sehovm.myapplication.domain.UserListRepository
import com.sehovm.myapplication.presentation.MainActivity

object UserListRepositoryImpl: UserListRepository {
//    val mainActivity = MainActivity()
//    val dbManager = DBManager(mainActivity)

    override fun editUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        TODO()
    }

    override fun removeUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun getUserList(): ArrayList<User> {
        TODO("Not yet implemented")
    }


}