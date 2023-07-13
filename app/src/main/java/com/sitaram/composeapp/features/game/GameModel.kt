package com.sitaram.composeapp.features.game

import com.sitaram.composeapp.features.api.ApiCallInstance
import com.sitaram.composeapp.features.api.ApiServices
import com.sitaram.composeapp.features.game.pojo.GameItems
import retrofit2.Call

class GameModel {

    // call the api
    fun getGame(): Call<List<GameItems>>? {
        val apiService: ApiServices? = ApiCallInstance.getAPIServiceInstance()
        return apiService?.getGames()
    }
}