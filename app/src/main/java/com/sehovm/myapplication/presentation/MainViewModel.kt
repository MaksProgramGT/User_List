package com.sehovm.myapplication.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sehovm.myapplication.data.DBManager
import com.sehovm.myapplication.domain.AddUser
import com.sehovm.myapplication.domain.EditUser
import com.sehovm.myapplication.domain.GetUserById
import com.sehovm.myapplication.domain.GetUserList
import com.sehovm.myapplication.domain.RemoveUser
import com.sehovm.myapplication.domain.User

class MainViewModel(context: Context) : ViewModel() {
    private val dbManager = DBManager(context)

    private val getUserListInstance = GetUserList(dbManager)
    private val removeUserInstance = RemoveUser(dbManager)
    private val editUserInstance = EditUser(dbManager)
    private val addUserInstantiation = AddUser(dbManager)

    val userList = MutableLiveData<List<User>>()

    fun removeUser(user: User) {
        removeUserInstance.removeUser(user)
        getUserList()
    }

    fun editUser(user: User) {
        editUserInstance.editUser(user)
        getUserList()
    }

    fun getUserList() {
        val list = getUserListInstance.getUserList()
        userList.value = list
    }

    fun addUserList(user: User) {
        addUserInstantiation.addUser(user)
        getUserList()
    }
}