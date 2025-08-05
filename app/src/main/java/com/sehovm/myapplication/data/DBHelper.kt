package com.sehovm.myapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sehovm.myapplication.domain.User

class DBHelper(val context: Context) :
    SQLiteOpenHelper(context, "userdb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE users (id INT PRIMARY KEY, fio TEXT, photo BLOB, address TEXT, phoneNumber TEXT, email TEXT, birthday TEXT, password TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
}