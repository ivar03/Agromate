package com.ivar7284.agromate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBtn: LinearLayout
    private lateinit var profileBtn: LinearLayout
    private lateinit var addImagesBtn: View
    private lateinit var nitrogen: EditText
    private lateinit var phosphorus: EditText
    private lateinit var potassium: EditText
    private lateinit var phLevel: EditText
    private lateinit var rainfall: EditText
    private lateinit var state: EditText
    private lateinit var city: EditText
    private lateinit var suggestBtn: Button
    private lateinit var suggestion_tv: TextView
    private lateinit var cropnav: TextView
    private lateinit var fertilizernav: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        overridePendingTransition(0, 0)
        //form and result
        nitrogen = findViewById(R.id.Cnitrogen_et)
        phosphorus = findViewById(R.id.Cphosphorus_et)
        potassium = findViewById(R.id.Cpotassium_et)
        phLevel = findViewById(R.id.CphLevel_et)
        rainfall = findViewById(R.id.Crainfall_et)
        state = findViewById(R.id.CState_et)
        city = findViewById(R.id.Ccity_et)
        suggestBtn = findViewById(R.id.suggestBtn)
        suggestion_tv = findViewById(R.id.suggestion_tv)
        cropnav = findViewById(R.id.Ccrop_tv)
        fertilizernav = findViewById(R.id.Cfertilizer_tv)

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
        profileBtn = findViewById(R.id.HprofileLayout)
        homeBtn = findViewById(R.id.HhomeLayout)

        homeBtn.setOnClickListener {
            startActivity(Intent(applicationContext,HomeActivity::class.java))
            finish()
        }
        profileBtn.setOnClickListener {
            startActivity(Intent(applicationContext,ProfileActivity::class.java))
        }
        //add images for disease detection activity
        addImagesBtn = findViewById(R.id.HaddImages)
        addImagesBtn.setOnClickListener {
            startActivity(Intent(applicationContext, AddImagesActivity::class.java))
            finish()
        }

    }
    //
}