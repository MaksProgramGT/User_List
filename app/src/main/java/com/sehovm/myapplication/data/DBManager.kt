package com.sehovm.myapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sehovm.myapplication.domain.User
import com.sehovm.myapplication.domain.UserListRepository

class DBManager(context: Context) : UserListRepository {
    val dbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    override fun editUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        val values = ContentValues().apply {
            put("fio", user.fio)
            put("photo", user.photo)
            put("address", user.address)
            put("phoneNumber", user.phoneNumber)
            put("email", user.email)
            put("birthday", user.birthday)
            put("password", user.password)
        }

        db?.insert("users", null, values)
    }

    override fun removeUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Int): User? {
        var user: User? = null
        var cursor = db?.query("users", null, null, null, null, null, null)

        while (cursor?.moveToNext() == true) {
            val userId = cursor.getString(cursor.getColumnIndexOrThrow("id")).toInt()
            if (userId == id) {
                val fio = cursor.getString(cursor.getColumnIndexOrThrow("fio"))
                val photo = cursor.getString(cursor.getColumnIndexOrThrow("photo")).toByteArray()
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val birthday = cursor.getString(cursor.getColumnIndexOrThrow("birthday"))
                val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
                user = User(userId, fio, photo, address, phoneNumber, email, birthday, password)
                break
            }
        }

        cursor?.close()

        return user
    }

    override fun getUserList(): ArrayList<User> {
        val userList = ArrayList<User>()
        var cursor = db?.query("users", null, null, null, null, null, null)

        while (cursor?.moveToNext() == true) {
            val id = cursor.getString(cursor.getColumnIndexOrThrow("id")).toInt()
            val fio = cursor.getString(cursor.getColumnIndexOrThrow("fio"))
            val photo = cursor.getString(cursor.getColumnIndexOrThrow("photo")).toByteArray()
            val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
            val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val birthday = cursor.getString(cursor.getColumnIndexOrThrow("birthday"))
            val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            userList.add(User(id, fio, photo, address, phoneNumber, email, birthday, password))
        }

        cursor?.close()

        return userList
    }

    fun openDB() {
        db = dbHelper.writableDatabase
    }

    fun closeDB() {
        dbHelper.close()
    }
}