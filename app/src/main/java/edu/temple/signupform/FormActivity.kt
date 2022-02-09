package edu.temple.signupform

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            var validFields: Boolean = CheckAllFields(nameField, emailField, passwordField, passwordFieldConfirm)

            if (validFields){
                var toastString = "Hello ".plus(nameField.text).plus(" to the SignUpForm App")
                val validInputToast = Toast.makeText(applicationContext, toastString, Toast.LENGTH_LONG)
                validInputToast.show()
            }
        }

    }

    private fun CheckAllFields(nameField: EditText, emailField: EditText, passwordField: EditText, passwordFieldConfirm: EditText): Boolean {

        var validFields: Boolean = true

        if (nameField.length() === 0) {
            nameField.setError("Name is required")
            validFields = false
        }

        if (emailField.length() === 0) {
            emailField.setError("Email is required")
            validFields = false
        }
        if (passwordField.length() === 0) {
            passwordField.setError("Password is required")
            validFields = false
        }
        else if (passwordFieldConfirm.length() === 0) {
            passwordFieldConfirm.setError("Password must be confirmed")
            validFields = false
        }

        var pw1: String = passwordField.text.toString()
        var pw2: String = passwordFieldConfirm.text.toString()
        if (pw1.equals(pw2) == false){
            passwordFieldConfirm.setError("Passwords must match")
            validFields = false
        }

        // after all validation return bool.
        return validFields
    }


}