package br.pro.aguiar.dkaep4.apiservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var instance : Retrofit? = null
    private val url : String = "http://biblio.aguiar.pro.br/"
    private fun getInstance(): Retrofit {
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance as Retrofit
    }

    fun getLivrosService() : LivrosService
            = getInstance().create(LivrosService::class.java)
}