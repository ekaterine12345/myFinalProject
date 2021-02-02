package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_bin_to_dec.*

class BinToDecActivity : AppCompatActivity() {
    var bin:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bin_to_dec)
        init()
    }
    private fun init() {
    convertBinButton.setOnClickListener{
        bin=binary_ET.text.toString().toLong()

        decimal_TV.visibility= View.VISIBLE
        decimal_TV.text=binToDecConvertor(bin).toString()
    }
    }


    private fun binToDecConvertor(binary: Long):Int
    {
        var bin=binary
        var dec=0
        var p=0

        while (bin.toInt()!=0)
        {
            dec+=(bin%10 * Math.pow(2.0,p.toDouble())).toInt()
            p++
            bin/=10
        }


        return dec
    }
}