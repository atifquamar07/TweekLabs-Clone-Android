package com.example.tweeklabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
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

    }
}