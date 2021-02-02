package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gcd_lcm.*

class GCD_LCMActivity : AppCompatActivity() {
    var a=0
    var b=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gcd_lcm)
        init()
    }

    private fun init()
    {
        buttonCalculate.setOnClickListener{
            a=EditTextA.text.toString().toInt()
            b=EditTextB.text.toString().toInt()

            if (a<=0 || b<=0) {
                                answerGCD_TV.visibility= View.GONE
                                answerLCM_TV.visibility= View.GONE
                                Toast.makeText(this,"numbers must be positive integers", Toast.LENGTH_SHORT).show()
            }
            else {
                answerGCD_TV.visibility= View.VISIBLE
                answerLCM_TV.visibility= View.VISIBLE
                answerGCD_TV.text="gcd("+a.toString()+","+b.toString()+")="+calculateGCD(a,b).toString()
                answerLCM_TV.text="lcm("+a.toString()+","+b.toString()+")="+calculateLCM(a,b).toString()
            }

        }

    }

    private fun calculateGCD(a:Int,b:Int):Int
    {
        var i = 1
        var gcd=1
        while (i<=a && i<=b) {

            if (a%i==0 && b%i==0) gcd = i
            i++
        }

        return gcd
    }

    private fun calculateLCM(a:Int,b:Int):Int
    {
        var lcm= maxOf(a,b)

        while (true)
        {
            if (lcm%a==0 && lcm%b==0) break
            lcm++
        }


        return lcm
    }

}