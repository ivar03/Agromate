package com.ivar7284.agromate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class FertilizerActivity : AppCompatActivity() {

    private lateinit var homeBtn: LinearLayout
    private lateinit var profileBtn: LinearLayout
    private lateinit var addImagesBtn: View
    private lateinit var nitrogen: EditText
    private lateinit var phosphorus: EditText
    private lateinit var potassium: EditText
    private lateinit var usercrop: EditText
    private lateinit var suggestBtn: Button
    private lateinit var suggestion_tv: TextView
    private lateinit var cropnav: TextView
    private lateinit var fertilizernav: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fertilizer)
        overridePendingTransition(0,0)

        //form and result
        nitrogen = findViewById(R.id.Fnitrogen_et)
        phosphorus = findViewById(R.id.Fphosphorus_et)
        potassium = findViewById(R.id.Fpotassium_et)
        usercrop = findViewById(R.id.Fusercrop_et)
        suggestBtn = findViewById(R.id.FsuggestBtn)
        suggestion_tv = findViewById(R.id.Fsuggestion_tv)
        cropnav = findViewById(R.id.Fcrop_tv)
        fertilizernav = findViewById(R.id.Ffertilizer_tv)

        cropnav.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }
        fertilizernav.setOnClickListener {
            startActivity(Intent(applicationContext, FertilizerActivity::class.java))
            finish()
        }

        //connection to the ml model

        //profile and home button
        profileBtn = findViewById(R.id.FprofileLayout)
        homeBtn = findViewById(R.id.FhomeLayout)

        homeBtn.setOnClickListener {
            startActivity(Intent(applicationContext,HomeActivity::class.java))
            finish()
        }
        profileBtn.setOnClickListener {
            startActivity(Intent(applicationContext,ProfileActivity::class.java))
        }
        //add images for disease detection activity
        addImagesBtn = findViewById(R.id.FaddImages)
        addImagesBtn.setOnClickListener {
            startActivity(Intent(applicationContext, AddImagesActivity::class.java))
            finish()
        }
    }
    //
}