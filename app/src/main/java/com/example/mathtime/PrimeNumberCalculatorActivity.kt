package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_prime_number_calculator.*

class PrimeNumberCalculatorActivity : AppCompatActivity() {
    var n=0
    var m=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prime_number_calculator)
        init()
    }

    private fun init()
    {
        buttonCalculate.setOnClickListener{
            n=EditTextN.text.toString().toInt()
            m=EditTextM.text.toString().toInt()

            if (m<n) {
                Toast.makeText(this,"first number must be less than second", Toast.LENGTH_SHORT).show()
                primeNumbersTV.visibility= View.GONE
                primeNumbersTV.text=""
                }
            else
            if (m<=0 || n<=0) {
                    Toast.makeText(this,"numbers must be positive integers", Toast.LENGTH_SHORT).show()
                    primeNumbersTV.visibility= View.GONE
                    primeNumbersTV.text=""
                 }
            else
                {
                    primeNumbersTV.visibility= View.VISIBLE
                    primeNumbersTV.text="prime numbers: "
                    if (n==1) n++

                    while (n<=m)
                    {
                        if (checkPrimeNumber(n)) primeNumbersTV.text=primeNumbersTV.text.toString()+" "+n.toString()
                        n++
                    }
                }


        }
    }

    private fun checkPrimeNumber(x:Int):Boolean
    {
        var isPrime=true

        for (i in 2..x/2)
        {
            if (x%i==0) {
                isPrime=false
                break
            }
        }

        return isPrime
    }
}