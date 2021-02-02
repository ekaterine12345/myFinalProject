package com.example.mathtime

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    val questionsArray= arrayOf<String>("which of them is prime number?","gcd(9,27)=","2*7=","lcm(2,9)=","3*4=",
                                        "10*3","17+32","gcd(24,27)=","which of them is even?","pow(2,9)")
    val choicesArray: Array<Array<String>> = arrayOf(
        arrayOf("1", "5", "8", "9"),
        arrayOf("27", "6", "7", "9"),
        arrayOf("14", "0", "3", "5"),
        arrayOf("20", "5", "18", "8"),
        arrayOf("10", "16", "12", "9"),

        arrayOf("9", "17", "30", "0"),
        arrayOf("32", "49", "39", "57"),
        arrayOf("6", "4", "3", "2"),
        arrayOf("5", "8", "13", "93"),
        arrayOf("32", "2048", "1024", "512")
    )

    val correctAnswersArray= arrayOf<String>("5","9","14","18","12","30","49","3","8","512")

    var questionIndex=0
    var score=0
    var correctAnswer=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()
    }

    private fun init() {


        button1.setOnClickListener {
            correctAnswer=correctAnswersArray.get(questionIndex)
          if (button1.text.toString().equals(correctAnswer))
          {
              button1.setBackgroundColor(Color.GREEN)
              score++

          }
          else
          {
              Toast.makeText(this,"correct is $correctAnswer", Toast.LENGTH_SHORT).show()
              button1.setBackgroundColor(Color.RED)
          }


            clickStop()
        }


        button2.setOnClickListener {
            correctAnswer=correctAnswersArray.get(questionIndex)
            if (button2.text.toString().equals(correctAnswer))
            {
                button2.setBackgroundColor(Color.GREEN)
                score++
            }
            else
            {
                Toast.makeText(this,"correct is $correctAnswer", Toast.LENGTH_SHORT).show()
                button2.setBackgroundColor(Color.RED)
            }


            clickStop()
        }

        button3.setOnClickListener {
            correctAnswer=correctAnswersArray.get(questionIndex)
            if (button3.text.toString().equals(correctAnswer))
            {
                button3.setBackgroundColor(Color.GREEN)
                score++
            }
            else
            {
                Toast.makeText(this,"correct is $correctAnswer", Toast.LENGTH_SHORT).show()
                button3.setBackgroundColor(Color.RED)
            }

            clickStop()
        }

        button4.setOnClickListener {
            correctAnswer=correctAnswersArray.get(questionIndex)
            if (button4.text.toString().equals(correctAnswer))
            {
                button4.setBackgroundColor(Color.GREEN)
                score++
            }
            else
            {
                Toast.makeText(this,"correct is $correctAnswer", Toast.LENGTH_SHORT).show()
                button4.setBackgroundColor(Color.RED)
            }

            clickStop()
        }


        buttonNext.setOnClickListener{
            questionIndex++
            if (questionIndex==questionsArray.size-1) buttonNext.text="finish"

            if (questionIndex!=questionsArray.size)
            {
                questionTV.setText(questionsArray.get(questionIndex))
                button1.text=choicesArray.get(questionIndex).get(0)
                button2.text=choicesArray.get(questionIndex).get(1)
                button3.text=choicesArray.get(questionIndex).get(2)
                button4.text=choicesArray.get(questionIndex).get(3)

                button1.setBackgroundColor(Color.WHITE)
                button2.setBackgroundColor(Color.WHITE)
                button3.setBackgroundColor(Color.WHITE)
                button4.setBackgroundColor(Color.WHITE)

                button1.isClickable=true
                button2.isClickable=true
                button3.isClickable=true
                button4.isClickable=true
            }
            else
            {
                button1.visibility=View.GONE
                button2.visibility=View.GONE
                button3.visibility=View.GONE
                button4.visibility=View.GONE

                buttonNext.visibility=View.GONE

                questionTV.text="   Your Score  "+score+"/"+questionsArray.size
            }


        }
    }

    private fun clickStop()
    {
        button1.isClickable=false
        button2.isClickable=false
        button3.isClickable=false
        button4.isClickable=false
    }

}