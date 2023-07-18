package com.sitaram.composeapp.features.update

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.sitaram.composeapp.features.util.Validator

class ForgotPasswordViewModel: ViewModel() {

    private val forgotPasswordModel = ForgotPasswordModel()
    private val validator = Validator()

    // test field empty check
    fun userEmail(email: String, context: Context): Boolean {
        return if (email.isEmpty()){
            Toast.makeText(context, "The field is empty!", Toast.LENGTH_SHORT).show()
            false
        } else {
            return getUserEmail(email, context)
        }
    }

    // email validation check
    private fun getUserEmail(email: String, context: Context): Boolean {
        val isBoolean = validator.emailValidation(email)
        return if (!isBoolean){
            Toast.makeText(context, "Invalid your email!", Toast.LENGTH_SHORT).show()
            false
        } else {
            return forgotPasswordModel.userEmail(email, context)
        }
    }

    // test field empty check
    fun userPassword(email: String, password: String, context: Context): Boolean {
        return if (email.isEmpty()){
            Toast.makeText(context, "The field is empty!", Toast.LENGTH_SHORT).show()
            false
        } else {
            return getUserPassword(email, password, context)
        }
    }

    // password validation check
    private fun getUserPassword(email: String, password: String, context: Context): Boolean {
        val isChange = forgotPasswordModel.userPassword(email, password, context)
        return if (isChange){
            Toast.makeText(context, "Password successfully change.", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(context, "Invalid your email!", Toast.LENGTH_SHORT).show()
            return false
        }
    }

}