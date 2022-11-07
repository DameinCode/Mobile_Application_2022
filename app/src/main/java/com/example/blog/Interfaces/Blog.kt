package com.example.blog.Interfaces

import java.util.Date

interface Blog {
    val content: String
    val date: Date
    val time: Date
    val comments: List<Comment>
    val reactions: HashMap<String, Int>
    val themes: List<String>
    val photo: String
}