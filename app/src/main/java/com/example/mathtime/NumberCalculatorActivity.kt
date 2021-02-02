package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_calculator.*

class NumberCalculatorActivity : AppCompatActivity() {
    var number=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_calculator)
        init()
    }

    private fun init()
    {
        calculateN.setOnClickListener {
            number=number_ET.text.toString().toInt()

            if (number<1)
            {
                answerDigitSum_TV.text=""
                answerSum_TV.text=""
                answerDivisions_TV.text=""

                answerDigitSum_TV.visibility= View.GONE
                answerDivisions_TV.visibility= View.GONE
                answerSum_TV.visibility= View.GONE

                Toast.makeText(this,"numbers must be positive integers", Toast.LENGTH_SHORT).show()

            }
            else
            {
                answerDigitSum_TV.visibility= View.VISIBLE
                answerDivisions_TV.visibility= View.VISIBLE
                answerSum_TV.visibility= View.VISIBLE

                answerSum_TV.text="sum of Integers from 1 to "+number.toString()+" is "+(number*(number+1)/2).toString()
                answerDigitSum_TV.text="Sum of digits of "+number.toString()+" is "+sumDigit(number).toString()
                answerDivisions_TV.text="Divisions of "+number.toString()

                for (i in 1..number)
                {
                    if (number%i==0) answerDivisions_TV.text=answerDivisions_TV.text.toString()+" "+i.toString()
                }

            }

        }
    }


    private fun sumDigit(n:Int):Int
    {
        var s=0
        var n=n

        while(n>0)
        {
            s+=n%10
            n/=10
        }
        return s
    }


}