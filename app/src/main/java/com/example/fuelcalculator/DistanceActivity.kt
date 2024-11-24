package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val DISTANCE = "distance"
class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.distance)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val distance = findViewById<TextInputEditText>(R.id.distanceCar)
        val next = findViewById<Button>(R.id.next4)
        val priceFuel: String? = intent.getStringExtra(PRICE_FUEL)
        val priceCar: String? = intent.getStringExtra(PRICE_CAR)

        next.setOnClickListener {
            val distanceStr = distance.text.toString()
            if (distanceStr.isEmpty()) {
                Snackbar.make(next, "Please, insert a value!", Snackbar.LENGTH_LONG).show()
            }
            else {
                val explicitIntent = Intent(this, DistanceActivity::class.java)
                explicitIntent.putExtra(PRICE_FUEL,priceFuel)
                explicitIntent.putExtra(PRICE_CAR, priceCar)
                explicitIntent.putExtra(DISTANCE, distanceStr)
                startActivity(explicitIntent)
            }
        }

    }
}