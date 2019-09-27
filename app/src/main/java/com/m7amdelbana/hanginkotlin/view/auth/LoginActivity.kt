package com.m7amdelbana.hanginkotlin.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.m7amdelbana.hanginkotlin.R
import com.m7amdelbana.hanginkotlin.util.LoadingDialog
import com.m7amdelbana.hanginkotlin.view.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())

    var dialog: LoadingDialog? = null

    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.login_email_editText)
        edtPassword = findViewById(R.id.login_password_editText)
        btnLogin = findViewById(R.id.login_button)

        dialog = LoadingDialog(this)

        btnLogin.setOnClickListener {
            presenter.validateCredentials(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    override fun showProgress() {
        dialog!!.show()
    }

    override fun hideProgress() {
        dialog!!.hide()
    }

    override fun emailError() {
        edtEmail.error = getString(R.string.wrong_email_address)
    }

    override fun passwordError() {
        edtPassword.error = getString(R.string.wrong_password)
    }

    override fun validCredentials() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun invalidCredentials() {
        Toast.makeText(this, getString(R.string.wrong_email_or_password),
            Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
