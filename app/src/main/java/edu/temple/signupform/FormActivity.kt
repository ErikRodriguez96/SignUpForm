package edu.temple.signupform

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val nameField: EditText = findViewById<EditText>(R.id.nameField)
        val emailField: EditText = findViewById<EditText>(R.id.emailField)
        val passwordField: EditText = findViewById<EditText>(R.id.passwordField)
        val passwordFieldConfirm: EditText = findViewById<EditText>(R.id.passwordFieldConfirm)

        saveButton.setOnClickListener{
            var pw: String = passwordField.text.toString()
            var pwConfirm: String = passwordFieldConfirm.text.toString()

            var validFields: Boolean = CheckAllFields(nameField, emailField, passwordField, passwordFieldConfirm)
        }

    }

    private fun CheckAllFields(nameField: EditText, emailField: EditText, passwordField: EditText, passwordFieldConfirm: EditText): Boolean {
        if (nameField.length() === 0) {
            nameField.setError("Name is required")
            return false
        }

        if (emailField.length() === 0) {
            emailField.setError("Email is required")
            return false
        }
        if (passwordField.length() === 0) {
            passwordField.setError("Password is required")
            return false
        }
        else if (passwordFieldConfirm.length() === 0) {
            passwordFieldConfirm.setError("Password must be confirmed")
            return false
        }

        // after all validation return true.
        return true
    }


}