package com.sehovm.myapplication.domain

//import androidx.compose.ui.graphics.ImageBitmap

data class User(
    val id: Int,
    val fio: String,
    val photo: ByteArray,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val birthday: String,
    val password: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (fio != other.fio) return false
        if (!photo.contentEquals(other.photo)) return false
        if (address != other.address) return false
        if (phoneNumber != other.phoneNumber) return false
        if (email != other.email) return false
        if (birthday != other.birthday) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + fio.hashCode()
        result = 31 * result + photo.contentHashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + birthday.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}
