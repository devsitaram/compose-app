package com.sitaram.composeapp.features.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.sitaram.composeapp.features.login.LoginModel

class LoginViewModel: ViewModel() {

    // create the object of Login Model class
    private val loginModel = LoginModel()

    fun loginDetails(userName: String, userPassword: String, context: Context): Boolean? {
        return if (userName.isEmpty() || userPassword.isEmpty()){
            Toast.makeText(context, "The fields is empty!", Toast.LENGTH_SHORT).show()
            false
        } else {
            return getUser(userName, userPassword, context)
        }
    }

    private fun getUser(userName: String, userPassword: String, context: Context): Boolean? {
        val isSuccess = loginModel.getLoginUser(userName, userPassword, context)
        return if (isSuccess == true) {
            true
        } else {
            return false
        }
    }

}