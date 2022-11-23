package com.momentum.structurecoroutines.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        private const val baseUrl = "https://api.github.com/search/"

        fun getRetroInstance() : Retrofit {

            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

}