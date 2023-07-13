package com.sitaram.composeapp.features.register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.sitaram.composeapp.features.util.Validation

class SignUpViewModel: ViewModel() {

    private val signUpModel = SignUpModel()
    private val validation = Validation()

    // register function
    fun registerDetail(userEmail: String, userName: String, userPassword: String, context: Context): Boolean {

        // initialize the variable
        val isValidEmail = validation.emailValidation(userEmail)
        val isValidName = validation.nameValidation(userName)

        return if (isValidEmail && isValidName) {
            // call the register button click method
            val isRegisterSuccess = signUpModel.registerDetails(userEmail, userName, userPassword, context)
            return if (isRegisterSuccess == true) {
                Toast.makeText(context, "Register Success.", Toast.LENGTH_SHORT).show()
                true
            } else {
                Toast.makeText(context, "Please enter the valid data!", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(context, "Enter the valid details!", Toast.LENGTH_SHORT).show()
            false
        }
    }
}