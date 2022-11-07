package com.example.blog.Interfaces

import java.util.Date

interface Comment {
    val date: Date
    val author: User
    val content: String
}