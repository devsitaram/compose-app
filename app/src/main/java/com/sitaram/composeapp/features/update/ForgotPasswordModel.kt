package com.sitaram.composeapp.features.update

import android.content.Context
import android.widget.Toast
import com.sitaram.composeapp.features.database.sqlite.SQLiterDBHelper

class ForgotPasswordModel {

    // email check
    fun userEmail(email: String, context: Context): Boolean {
        val isSuccess = SQLiterDBHelper(context).getUserEmail(email)
        return if (isSuccess) {
            true
        } else {
            Toast.makeText(context, "Your mail is not register!", Toast.LENGTH_SHORT).show()
            return false
        }
    }

    // password update
    fun userPassword(email: String, password: String, context: Context): Boolean {
        return SQLiterDBHelper(context).updatePassword(email, password)
    }
}