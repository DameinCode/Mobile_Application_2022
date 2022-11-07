package com.example.blog.Interfaces

import android.provider.ContactsContract.CommonDataKinds.Email

interface User {
    val username: String
    val bio: String
    val name: String
    val email: Email
    val subscribers: List<User>
    val followings: List<User>
    val photo: String
    val blogs: List<Blog>
    val typeOfAccount: String
    val password: String
}