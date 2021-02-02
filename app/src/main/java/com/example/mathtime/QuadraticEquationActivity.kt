package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quadratic_equation.*

class QuadraticEquationActivity : AppCompatActivity() {
    var a=0.0
    var b=0.0
    var c=0.0
    var x1=0.0
    var x2=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadratic_equation)
        init()
    }

    private fun init()
    {
        buttonCalculateQE.setOnClickListener{
            a=EditTextA.text.toString().toDouble()
            b=EditTextB.text.toString().toDouble()
            c=EditTextC.text.toString().toDouble()

            val D= b*b-4.0*a*c

            discriminantTV.visibility= View.VISIBLE

            discriminantTV.text="D="+D.toString()

            rootsTV.visibility=View.GONE

            if (D<0) Toast.makeText(this,"The discriminant is less than 0", Toast.LENGTH_SHORT).show()
            else
            {
                rootsTV.visibility= View.VISIBLE
                a*=2
                if (D>0)
                {
                    x1=(-b-Math.sqrt(D))/a
                    x2=(-b+Math.sqrt(D))/a
                    rootsTV.text="x1="+x1.toString()+"\n x2="+x2.toString()
                }
                else
                {
                    x1=-b/a
                    x2=x1

                    rootsTV.text="x1=x2="+x1.toString()
                }


            }


        }
    }
}