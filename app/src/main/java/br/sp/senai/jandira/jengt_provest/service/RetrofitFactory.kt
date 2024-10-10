package br.senai.sp.jandira.rickandmortyapi.service

import br.sp.senai.jandira.jengt_provest.service.TemaRedacaoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://jengt-provest-backend.onrender.com/v1/jengt_provest/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAlunoService(): AlunoService{
        return retrofitFactory.create(AlunoService::class.java)
    }

    fun getTemaRedacaoService(): TemaRedacaoService {
        return retrofitFactory.create(TemaRedacaoService::class.java)
    }
}