package com.example.blog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Profile : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<BlogAdapter.MyViewHolder>? = null
//    private var blogModels: ArrayList<Blog> = arrayListOf()
    var images: Array<Uri> = arrayOf(Uri.parse("android.resource://com.example.blog/drawable/test1"), Uri.parse("android.resource://com.example.blog/drawable/test2"), Uri.parse("android.resource://com.example.blog/drawable/test3"))

    companion object {
        var blogModels: ArrayList<Blog> = arrayListOf()
        var adapter: RecyclerView.Adapter<BlogAdapter.MyViewHolder>? = null
        fun updateBlog(content: String, image: Uri) {
            blogModels.add(Blog(content, Calendar.getInstance().time, arrayOf("cool", "great", "adventure"), image))
            adapter?.notifyItemInserted(blogModels.size+1)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val recyclerView: RecyclerView = findViewById(R.id.blogs)
        setUpBlogs()
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = BlogAdapter(blogModels)
        recyclerView.adapter = adapter

//        Adding new blog to the array
        val button = findViewById<Button>(R.id.add_blog_button)
        button.setOnClickListener {
            val intent = Intent(this, BlogEdit::class.java)
//            startActivityForResult(intent, 2);
            startActivity(intent)
        }


//        Updating the blog or deleting
        recyclerView.setOnItemClickListener()
    }


    private fun setUpBlogs() {
        var listOfContent = resources.getStringArray(R.array.initial_blog_contents)
        var themes = arrayOf("cool", "great", "adventure")
        for(i in 0..listOfContent.size-1) {
            blogModels.add(Blog(listOfContent[i], Calendar.getInstance().time, themes, images[i]))
//            blogModels.add(Blog(element, Calendar.getInstance().time, themes))

        }
    }
}