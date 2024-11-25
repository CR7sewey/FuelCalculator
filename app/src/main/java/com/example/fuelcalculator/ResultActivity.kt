package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.math.BigDecimal
import java.math.RoundingMode

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price: String? = intent.getStringExtra(PRICE_FUEL)
        val consumption: String? = intent.getStringExtra(PRICE_CAR)
        val distance: String? = intent.getStringExtra(DISTANCE)

        var explicitIntent: Intent

        if (price.isNullOrBlank() || consumption.isNullOrBlank() || distance.isNullOrBlank()) {
            explicitIntent = Intent(this, PriceActivity::class.java)
            startActivity(explicitIntent)
        }

        val result = findViewById<TextView>(R.id.result)
        val resultBD = BigDecimal(price?.toDouble()!! * consumption?.toDouble()!!/100 * distance?.toDouble()!!).setScale(1, RoundingMode.HALF_EVEN)
        result.text = resultBD.toString() + "€"

        val priceLabel = findViewById<TextView>(R.id.priceFuel)
        priceLabel.text = price
        val consumptionLabel = findViewById<TextView>(R.id.consumption)
        consumptionLabel.text = consumption
        val distanceLabel = findViewById<TextView>(R.id.distance)
        distanceLabel.text = distance

        val newCalc = findViewById<Button>(R.id.next5)

        newCalc.setOnClickListener {
            explicitIntent = Intent(this, MainActivity::class.java)
            startActivity(explicitIntent)
        }

    }
}