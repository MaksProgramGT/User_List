package com.sehovm.myapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sehovm.myapplication.domain.User

class DBManager(context: Context) {
    val dbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    fun editUser(user: User) {
        var values = getValues(user)

        db?.update("users", values, "id=?", arrayOf(user.id.toString()))
    }

    fun addUser(user: User) {
        var values = getValues(user)

        db?.insert("users", null, values)
    }

    fun removeUser(user: User) {
        db?.delete("users", "id = ?", arrayOf(user.id.toString()))
    }

    fun getUserById(id: Int): User {
        var user: User? = null
        var cursor = db?.query("users", null, null, null, null, null, null)

        //cursor?.

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

        return user ?: throw RuntimeException("Element with $id not found")
    }

    fun getUserList(): ArrayList<User> {
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

    fun getValues(user: User) : ContentValues {
        return ContentValues().apply {
            put("fio", user.fio)
            put("photo", user.photo)
            put("address", user.address)
            put("phoneNumber", user.phoneNumber)
            put("email", user.email)
            put("birthday", user.birthday)
            put("password", user.password)
        }
    }

    fun openDB() {
        db = dbHelper.writableDatabase
    }

    fun closeDB() {
        dbHelper.close()
    }
}