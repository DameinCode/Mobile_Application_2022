package com.example.blog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.util.*

class BlogEdit : AppCompatActivity() {

    private lateinit var imageToUpload: ImageView
    private lateinit var imgeURI: Uri
    lateinit var isurl: TextView


    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_edit)

        val addBlog = findViewById<Button>(R.id.add_blog_button)
        val uploadImage = findViewById<Button>(R.id.upload_image_btn)

        isurl = findViewById(R.id.isUrl)
        uploadImage.setOnClickListener {
            imageToUpload = findViewById<ImageView>(R.id.upload_block)
            pickImageGallery()
        }
        addBlog.setOnClickListener{
            val blogContent = findViewById<EditText>(R.id.blog_content_text)
            val image = findViewById<ImageView>(R.id.upload_block)
            MaterialAlertDialogBuilder(this)
                .setTitle("Alert")
                .setMessage("Are you sure to add this blog?")
                .setPositiveButton("Yes") {dialog, which ->
                    if(!checkIfValid(blogContent, image)) {
                        showSnackbar(it, "Invalid inputs. Check!")
                    } else {
                        Profile.updateBlog(blogContent.text.toString(), imgeURI)
                        showSnackbar(it, "Created!")
                        finish()
                    }
                }
                .setNegativeButton("No") {dialog, which ->
                    showSnackbar(it, "Ok. Not created!")
                }
                .show()

        }

//        forTest.setOnClickListener {
//            showing.text = blogContent.text.toString()
//        }
    }

    private fun showSnackbar(it: View, msg: String) {
        Snackbar.make(it, msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun checkIfValid(blogContent: TextView, image: ImageView): Boolean {
        if (image.getDrawable() == null) {
            return false
        } else if (blogContent.text.isBlank()) {
            return false
        }
        return true
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imageToUpload.setImageURI(data?.data)
            if (data != null) {
                imgeURI = data.data!!
            }
            imageToUpload.setImageURI(imgeURI)
        }
    }
}