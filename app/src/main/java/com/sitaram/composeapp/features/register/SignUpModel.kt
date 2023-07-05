package com.sitaram.composeapp.features.register

import android.content.Context
import com.sitaram.composeapp.features.database.sqlite.SQLiterDBHelper

class SignUpModel {

    // register function
    fun registerDetails(userEmail: String, userName: String, userPassword: String, context: Context): Boolean? {
        val databaseHelper = SQLiterDBHelper(context)
        // call the register button click method
        return databaseHelper.registerUser(userEmail, userName, userPassword)

    }
}