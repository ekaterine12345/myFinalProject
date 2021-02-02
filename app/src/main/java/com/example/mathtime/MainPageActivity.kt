package com.example.mathtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        init()
    }


    private fun init() {
        buttonTest.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        buttonPNC.setOnClickListener {
            val intent = Intent(this, PrimeNumberCalculatorActivity::class.java)
            startActivity(intent)
        }

        buttonQE.setOnClickListener {
            val intent = Intent(this, QuadraticEquationActivity::class.java)
            startActivity(intent)
        }

        buttonGCD_LCM.setOnClickListener {
            val intent = Intent(this, GCD_LCMActivity::class.java)
            startActivity(intent)
        }

        buttonBinToDec.setOnClickListener {
            val intent = Intent(this, BinToDecActivity::class.java)
            startActivity(intent)
        }

        buttonDecToBin.setOnClickListener {
            val intent = Intent(this, DecToBinActivity::class.java)
            startActivity(intent)
        }

        buttonCalculatorN.setOnClickListener {
            val intent = Intent(this, NumberCalculatorActivity::class.java)
            startActivity(intent)
        }

    }
}