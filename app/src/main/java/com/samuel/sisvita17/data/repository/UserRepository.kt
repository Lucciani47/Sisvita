package com.samuel.sisvita17.data.repository

import com.samuel.sisvita17.data.model.User
class UserRepository {

    private val dummyUser = User(username = "test", password = "1234")

    fun login(username: String, password: String): Boolean {
        return username == dummyUser.username && password == dummyUser.password
    }
}