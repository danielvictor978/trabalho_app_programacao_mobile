package com.rafael.loginappavaliacao.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.rafael.loginappavaliacao.R
import com.rafael.loginappavaliacao.ui.home.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var enterButton: Button
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emailInputLayout = findViewById(R.id.til_email)
        passwordInputLayout = findViewById(R.id.til_password)

        emailEditText = emailInputLayout.findViewById(R.id.et_email)
        passwordEditText = passwordInputLayout.findViewById(R.id.et_password)
        
        enterButton = findViewById(R.id.btn_signin)

        emailEditText.doAfterTextChanged { checkButtonState() }
        passwordEditText.doAfterTextChanged { checkButtonState() }

        enterButton.setOnClickListener {
            if (validateAndShowErrors()) {
                navigateToHome()
            }
        }

        enterButton.isEnabled = false
    }

    private fun checkButtonState() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()

        enterButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }

    private fun validateAndShowErrors(): Boolean {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        val isEmailPresent = email.isNotEmpty()
        val isPasswordPresent = password.isNotEmpty()
        val isEmailValid = isEmailPresent && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = isPasswordPresent && password.length >= 4

        if (!isEmailPresent) {
            emailInputLayout.error = "O e-mail é obrigatório"
        } else if (!isEmailValid) {
            emailInputLayout.error = "E-mail inválido"
        } else {
            emailInputLayout.error = null
        }

        if (!isPasswordPresent) {
            passwordInputLayout.error = "A senha é obrigatória"
        } else if (!isPasswordValid) {
            passwordInputLayout.error = "A senha requer 4 caracteres"
        } else {
            passwordInputLayout.error = null
        }

        return isEmailValid && isPasswordValid
    }

    private fun navigateToHome() {
        val email = emailEditText.text.toString().trim()
        val userName = extractUserName(email)

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("USER_NAME", userName)
        startActivity(intent)
        finish()
    }

    private fun extractUserName(email: String): String {
        val name = email.substringBefore("@")
        return name.replaceFirstChar { it.uppercase() }
    }
}