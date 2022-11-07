package com.example.blog

import android.net.Uri
import java.util.*
import kotlin.collections.ArrayList

class Blog {

    private var content: String
    private var date: Date
    private var themes: Array<String>
    private var photo: Uri

    //    lateinit var time: Date
//    lateinit var comments: ArrayList<Comment>
//    lateinit var reactions: HashMap<String, Int>

    constructor(content: String, date: Date, themes: Array<String>, photo: Uri) {
        this.content = content
        this.date = date
//        this.time = time
//        this.comments = comments
//        this.reactions = reactions
        this.themes = themes
        this.photo = photo
    }

    fun getBlogContent(): String {
        return content
    }

    fun getDateBlog(): Date {
        return date
    }

    @JvmName("getPhoto1")
    fun getPhoto(): Uri {
        return photo
    }

    @JvmName("getThemes1")
    fun getThemes(): Array<String> {
        return themes
    }

    fun setContent(content: String) {
        this.content = content
    }

    fun setPhoto(photo: Uri) {
        this.photo = photo
    }


    //    fun getTimeBlog():Date {
//        return time
//    }

    //    @JvmName("getComments1")
//    fun getComments(): List<Comment> {
//        return comments
//    }
//
//    @JvmName("getReactions1")
//    fun getReactions(): HashMap<String, Int> {
//        return reactions
//    }
}
