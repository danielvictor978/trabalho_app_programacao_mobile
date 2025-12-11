package com.rafael.loginappavaliacao.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.loginappavaliacao.R

class HomeActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        welcomeTextView = findViewById(R.id.tv_greeting)

        val userName = intent.getStringExtra("USER_NAME")

        if (!userName.isNullOrBlank()) {
            welcomeTextView.text = getString(R.string.welcome_message, userName)
        } else {
            welcomeTextView.text = "Bem vindo!"
        }
    }
}