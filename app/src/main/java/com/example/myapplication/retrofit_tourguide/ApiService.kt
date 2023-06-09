package com.example.myapplication.retrofit_tourguide

import com.example.myapplication.retrofit_destinasi.ApiEndPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {
    val BASE_URL: String = "http://192.168.0.103:4000/api/v1/"
    val endPoint: com.example.myapplication.retrofit_tourguide.ApiEndPoint
        get() {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(com.example.myapplication.retrofit_tourguide.ApiEndPoint::class.java)
//            retrofit.create(ApiEndPoint::class.java)
        }
}