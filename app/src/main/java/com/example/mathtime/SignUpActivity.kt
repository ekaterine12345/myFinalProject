package com.example.mathtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    private fun init()
    {

        auth = Firebase.auth
        signUpButton.setOnClickListener{

            signUp()
        }
    }


    private fun signUp()
    {
        val email: String=emailEditText.text.toString()
        val password: String= passwordEditText.text.toString()
        val repeatPassword:String=repeateEditText.text.toString()


        if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) Toast.makeText(this, "one or more filds are empty", Toast.LENGTH_SHORT).show()
        else
            if (password!=repeatPassword) Toast.makeText(this, "password is not same", Toast.LENGTH_SHORT).show()
            else
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()==false) Toast.makeText(this, "Email format is not Correct", Toast.LENGTH_SHORT).show()
                else
                {
                    progressBar.visibility= View.VISIBLE
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            progressBar.visibility= View.GONE
                            if (task.isSuccessful) {
                                d("sign up", "createUserWithEmail:success")
                                val user = auth.currentUser
                                Toast.makeText(baseContext, "SignUp is Success!", Toast.LENGTH_SHORT).show()

                            } else {
                                d("sign up", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                            }

                        }
                }

    }

}