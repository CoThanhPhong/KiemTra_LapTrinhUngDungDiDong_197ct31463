package com.vanlang.kiemtra_laptrinhungdungdidong_197ct31463

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Profile : AppCompatActivity() {
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        listView = findViewById(R.id.listView)

        val email = intent.getStringExtra("USER_EMAIL")
        if (email != null) {
            tvUserEmail.text = "Email: $email"
        }

        btnLogout.setOnClickListener {
            finish()
        }

        val subjects = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = subjects[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
    }
}