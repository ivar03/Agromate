package com.ivar7284.agromate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AddImagesActivity : AppCompatActivity() {

    lateinit var homeBtn: LinearLayout
    lateinit var profileBtn: LinearLayout
    lateinit var addImagesBtn: View

    private lateinit var uploadBtn: Button
    private lateinit var image: ImageView
    private val PICK_IMAGES_REQUEST = 123
    private val Max_IMAGES = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_images)
        overridePendingTransition(0, 0)

        //profile and home button
        profileBtn = findViewById(R.id.AprofileLayout)
        homeBtn = findViewById(R.id.AhomeLayout)

        profileBtn.setOnClickListener {
            startActivity(Intent(applicationContext, ProfileActivity::class.java))
        }
        homeBtn.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }

        //add images activity button
        addImagesBtn = findViewById(R.id.AaddImages)
        addImagesBtn.setOnClickListener {
            startActivity(Intent(applicationContext, AddImagesActivity::class.java))
            finish()
        }

        //get image for the plant disease to the ml model
        //uploading image
        image = findViewById(R.id.image)
        image.setOnClickListener {
            pickImages()
        }
        uploadBtn = findViewById(R.id.uploadBtn)
        uploadBtn.setOnClickListener {
            //supply to the ml model
        }


    }

    private fun pickImages(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent,PICK_IMAGES_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGES_REQUEST && resultCode == RESULT_OK) {
            val clipData = data?.clipData
            if (clipData != null) {
                for (i in 0 until minOf(clipData.itemCount, Max_IMAGES)) {
                    val uri = clipData.getItemAt(i).uri
                    Glide.with(this).load(uri).apply(RequestOptions().centerCrop()).into(image)
                }
                if (clipData.itemCount > Max_IMAGES) {
                    Toast.makeText(this, "You can only select up to 6 images", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    //
}