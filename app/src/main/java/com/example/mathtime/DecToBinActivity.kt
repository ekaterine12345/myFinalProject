package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_dec_to_bin.*

class DecToBinActivity : AppCompatActivity() {
    var dec=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dec_to_bin)
    init()
    }
    private fun init() {
        convertDecButton.setOnClickListener{

            dec=decimal_ET.text.toString().toInt()

            binary_TV.visibility= View.VISIBLE
            binary_TV.text=decToBinConvertor(dec).toString()
        }
    }

    private fun decToBinConvertor(decimal:Int):Long
    {
     var dec=decimal
     var bin:Long=0
     var p=1

        while(dec!=0)
        {
            bin+=(dec%2 * p).toLong()
            dec/=2
            p*=10
        }

        return bin
    }
}