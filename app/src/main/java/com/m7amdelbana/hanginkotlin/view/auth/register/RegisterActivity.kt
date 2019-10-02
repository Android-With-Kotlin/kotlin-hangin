package com.m7amdelbana.hanginkotlin.view.auth.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.m7amdelbana.hanginkotlin.R
import com.m7amdelbana.hanginkotlin.network.api.APIError
import com.m7amdelbana.hanginkotlin.network.api.APIOperationListener
import com.m7amdelbana.hanginkotlin.network.endpoint.auth.AuthRepository
import com.m7amdelbana.hanginkotlin.network.model.SignForm
import com.m7amdelbana.hanginkotlin.network.model.Token
import com.m7amdelbana.hanginkotlin.util.ErrorDialog
import com.m7amdelbana.hanginkotlin.util.LoadingDialog

class RegisterActivity : AppCompatActivity(), APIOperationListener {

    lateinit var tILFirstName: TextInputLayout
    lateinit var tILLastName: TextInputLayout
    lateinit var tILEmail: TextInputLayout
    lateinit var tILPhone: TextInputLayout
    lateinit var tILPassword: TextInputLayout
    lateinit var tILConfirmPassword: TextInputLayout
    lateinit var btnRegister: Button

    var loadingDialog: LoadingDialog? = null

    val REQUEST_REGSITER: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initUI()

        loadingDialog = LoadingDialog(this)

        btnRegister.setOnClickListener {
            try {
                validateInput()

                loadingDialog!!.show()
                // -------- Face Request --------
                AuthRepository.register(
                    REQUEST_REGSITER,
                    SignForm(
                        firstName = "Mohamed",
                        lastName = "Elbana",
                        email = "m7amdelbana1234567@gmail.com",
                        phone = "01149336618",
                        password = "123456"
                    ), this
                )

            } catch (error: Exception) {
                Toast.makeText(
                    this,
                    error.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun initUI() {
        tILFirstName = findViewById(R.id.registration_firstName_text_input_layout)
        tILLastName = findViewById(R.id.registration_lastName_text_input_layout)
        tILEmail = findViewById(R.id.registration_email_text_input_layout)
        tILPhone = findViewById(R.id.registration_phone_text_input_layout)
        tILPassword = findViewById(R.id.registration_password_text_input_layout)
        tILConfirmPassword = findViewById(R.id.registration_confirm_password_text_input_layout)
        btnRegister = findViewById(R.id.registration_submit_button)
    }

    private fun validateInput() {
        val firstName = tILFirstName.editText!!.text.toString().trim()

        when {
            firstName.isEmpty() -> throw Exception(getString(R.string.first_name_is_required))
        }
    }

    override fun onSuccess(requestId: Int, response: Any) {
        loadingDialog!!.hide()
        when (requestId) {
            REQUEST_REGSITER -> {
                val token: Token = response as Token
                Toast.makeText(
                    this,
                    token.accessToken,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onError(requestId: Int, error: APIError) {
        loadingDialog!!.hide()
        // -------- Validate All Fields --------
        when (requestId) {
            REQUEST_REGSITER -> ErrorDialog.show(error.mesage, this)
        }
    }
}



