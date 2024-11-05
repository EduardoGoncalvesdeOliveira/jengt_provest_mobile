package br.sp.senai.jandira.jengt_provest.service

import br.sp.senai.jandira.jengt_provest.model.Redacao
import br.sp.senai.jandira.jengt_provest.model.Results
import br.sp.senai.jandira.jengt_provest.model.TemaRedacao
import br.sp.senai.jandira.jengt_provest.model.TemaRedacaoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface TemaRedacaoService {

//    @GET("temas/{id}")
//    fun getTemasById(@Path("id") id: Int): Call<TemaRedacao>

    @GET("temas")
    fun getAllTemas(): Call<TemaRedacaoResponse>

//    @Headers("Content-Type: application/json")
//    @POST("temas")
//    fun postTemas(@Body redacao: Redacao): Call<Redacao>

}

