package com.example.tweeklabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var tvTweek: TextView
    private lateinit var tvLabs: TextView
    private lateinit var etPhoneNumber: TextView
    private lateinit var etPassword: TextView
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvTweek = findViewById(R.id.tv_tweek)
        tvLabs = findViewById(R.id.tv_labs)
        etPhoneNumber = findViewById(R.id.et_phone_number)
        etPassword = findViewById(R.id.et_password)
        btnSignIn = findViewById(R.id.btn_sign_in)
        btnSignUp = findViewById(R.id.btn_sign_up)
        val themeColor = ContextCompat.getColor(this, R.color.logo_orange)

        val txtTweek = "Tweek"
        val spannableTextTweek = SpannableString(txtTweek)
        spannableTextTweek.setSpan(ForegroundColorSpan(themeColor), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTweek.text = spannableTextTweek

        val txtLabs = "Labs"
        val spannableTextLabs = SpannableString(txtLabs)
        spannableTextLabs.setSpan(ForegroundColorSpan(themeColor), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvLabs.text = spannableTextLabs

        btnSignIn.setOnClickListener {
            val inputPhoneNumber = etPhoneNumber.text.toString()
            val inputPassword = etPassword.text.toString()
            if(inputPhoneNumber == ""){
                Toast.makeText(this, "Phone Number can't be Blank.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(inputPassword == ""){
                Toast.makeText(this, "Password can't be Blank.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val isUserAuthenticated = userAuthentication(inputPhoneNumber, inputPassword)
            if (isUserAuthenticated){
                Log.i("Authentication Status", "User is Valid.")
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AthletePageActivity::class.java)
                startActivity(intent)
            }
            else {
                Log.i("Authentication Status", "User is Invalid.")
                Toast.makeText(this, "Invalid Credentials.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    private fun userAuthentication(phoneNumber: String, password: String): Boolean {
        return (phoneNumber == "9876543210" && password == "9876543210")
    }
}