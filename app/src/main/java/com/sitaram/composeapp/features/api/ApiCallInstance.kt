package com.sitaram.composeapp.features.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ApiCallInstance {

    companion object {
        private var retrofit: Retrofit? = null
        // API base URL    https://www.geeksforgeeks.org/how-to-build-a-stock-market-news-android-app-using-retrofit/
        private const val BASE_URL = "https://www.freetogame.com/api/"

        // create the instance of retrofit
        @Synchronized
        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                // create the object of httpLoggingInterceptor
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                // create object of okHttpClient
                val okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

                // create an object of the retrofit
                retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) // converter
                    .build()
            }
            // return the retrofit
            return retrofit
        }
    }
}