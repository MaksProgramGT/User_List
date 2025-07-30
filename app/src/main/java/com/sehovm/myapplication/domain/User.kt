package com.sehovm.myapplication.domain

import androidx.compose.ui.graphics.ImageBitmap

data class User(
    val id: Int,
    val fio: String,
    val photo: ImageBitmap,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val birthday: String,
    val password: String
)
