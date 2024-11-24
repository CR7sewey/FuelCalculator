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

const val PRICE_FUEL = "price_fuel"
const val PRICE_CAR = "price_car"


class CarConsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_cons)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.car)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price = findViewById<TextInputEditText>(R.id.priceCar)
        val next = findViewById<Button>(R.id.next3)
        val priceFuel: String? = intent.getStringExtra(PRICE_FUEL)

        next.setOnClickListener {
            val priceStr = price.text.toString()
            if (priceStr.isEmpty()) {
                Snackbar.make(next, "Please, insert a value!", Snackbar.LENGTH_LONG).show()
            }
            else {
                val explicitIntent = Intent(this, CarConsActivity::class.java)
                explicitIntent.putExtra(PRICE_FUEL,priceFuel)
                explicitIntent.putExtra(PRICE_CAR, priceStr)
                startActivity(explicitIntent)
            }
        }
    }
}