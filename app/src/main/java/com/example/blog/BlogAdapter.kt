package com.example.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlogAdapter(blogs: ArrayList<Blog>): RecyclerView.Adapter<BlogAdapter.MyViewHolder>(){

    var blogList: ArrayList<Blog> = blogs
//    private var contents = arrayOf("This is where eTexts have advantages over traditional textbooks. eTexts offer hyperlinks to videos that demonstrate difficult concepts. They also provide a digital discussion space for learners using the same text. Besides 3-D images and audiobook options, eTexts can accommodate the visually impaired by enlarging texts and images and transposing colored images into black and white for the colorblind. eTexts offer the latest in innovative learning.", "Hi! Nice to meet you! My name is John Smith. I am 19 and a student in cses are Geometry, French, and History. English is my hardest course. My professors are very friendly and smart. It’s my second year in college now. I love it. I live in a big house on Ivy Street. It’s near the college campus. I sharh other with homework. On the weekend, we play football together. I have a younger brother. es they visit me in New York. I am happy whe. I really miss them, too!",
//    "Stephanie recently took a weekend trip to Los Angeions centered around Hollywood culture, there is a lot to see and visit in Los Angeles. Of course, all things related to Hollywood are popular tourist attractions. The Hollywood Sign, located the Hollywood Hills of the Santa Monica Mountains, is a famous landmark for this star-studded town. Once in downtown Hollywood, it’s possible to take a stroll along the Hollywood Walk of Fame. This landmark conta.")
//    private var images = arrayOf(R.drawable.test1, R.drawable.test2, R.drawable.test3)
//    private var themes = arrayOf("cool", "great", "adventure")

//   This is where you inflate the layout (Giving a look to our rows)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogAdapter.MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.blog_row, parent, false)
        return MyViewHolder(view)
    }

// Assigning values to the views we created in the blog_row layout file
//  based on position of the recycler view
    override fun onBindViewHolder(holder: BlogAdapter.MyViewHolder, position: Int) {
        holder.textView.text =  blogList[position].getBlogContent()
        holder.tv2.text = "Comments"
        holder.iconCom = holder.iconCom
        holder.viewv = holder.viewv
//        holder.imageView.setImageResource(images[position])
        holder.imageView.setImageURI(blogList[position].getPhoto())

    }

// recycler view just wants to know the number of items you want displayed
    override fun getItemCount(): Int {
        return blogList.size
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView
        var tv2: TextView
        var iconCom: ImageView
        var viewv: View

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.text_of_blog)
            tv2 = itemView.findViewById(R.id.textView2)
            iconCom = itemView.findViewById(R.id.comment_icon)
            viewv = itemView.findViewById(R.id.View03)
        }
    }
}

