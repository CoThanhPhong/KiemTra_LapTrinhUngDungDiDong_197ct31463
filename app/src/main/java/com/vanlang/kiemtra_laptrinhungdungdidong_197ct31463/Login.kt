package com.vanlang.kiemtra_laptrinhungdungdidong_197ct31463

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvMessage = findViewById(R.id.tvMessage)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                tvMessage.text = "Email không được để trống!"
                tvMessage.setTextColor(android.graphics.Color.RED)
            } else if (password.isEmpty()) {
                tvMessage.text = "Mật khẩu không được để trống!"
                tvMessage.setTextColor(android.graphics.Color.RED)
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvMessage.text = "Email không đúng định dạng!"
                tvMessage.setTextColor(android.graphics.Color.RED)
            } else if (password.length < 6) {
                tvMessage.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                tvMessage.setTextColor(android.graphics.Color.RED)
            }
            else {
                tvMessage.text = "Xác thực thành công!"
                tvMessage.setTextColor(android.graphics.Color.GREEN)
            }
        }
    }
}